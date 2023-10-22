package com.tablesoccer.database.tournament

import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import java.util.*

/**
 * сущность для общения с б.д.
 */
class TournamentsRepository {
    fun create(
        name: String,
        startDate: LocalDate,
        endDate: LocalDate,
        status: TournamentStatus,
        winner: String,
        maxNumOfTeams: Int,
    ): UUID {
        return transaction {
            TournamentsTable.insertAndGetId {
                it[TournamentsTable.name] = name
                it[TournamentsTable.startDate] = startDate
                it[TournamentsTable.endDate] = endDate
                it[TournamentsTable.status] = status.name
                it[TournamentsTable.winner] = winner
                it[TournamentsTable.maxNumOfTeams] = maxNumOfTeams
                //it[TournamentsTable.teamsIds] = teamsIds.toTeamsIdsString()
            }.value
        }
    }


    fun findById(tournamentId: UUID): TournamentModel? {
        return try {
            transaction {
                val tournamentModel = TournamentsTable.select { TournamentsTable.id.eq(tournamentId) }.single()
                TournamentModel(
                    tournamentId = tournamentModel[TournamentsTable.id].value,
                    name = tournamentModel[TournamentsTable.name],
                    startDate = tournamentModel[TournamentsTable.startDate],
                    endDate = tournamentModel[TournamentsTable.endDate],
                    status = TournamentStatus.valueOf(tournamentModel[TournamentsTable.status]),
                    winner = tournamentModel[TournamentsTable.winner],
                    maxNumOfTeams = tournamentModel[TournamentsTable.maxNumOfTeams],
                    teamsIds = tournamentModel[TournamentsTable.teamsIds].toTeamsIdsListUUID()
                )
            }
        } catch (e: Exception) {
            null
        }
    }
}