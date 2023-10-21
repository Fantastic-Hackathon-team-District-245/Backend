package com.tablesoccer.database.tournament

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.format.DateTimeFormatter

/**
 * сущность для общения с б.д.
 */
class TournamentsRepository {
    fun create(tournament: TournamentEntity){
        transaction {
            TournamentsTable.insert {
                it[tournamentID] = tournament.tournamentID
                it[name] = tournament.name
                it[startDate] = tournament.startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                it[status] = tournament.status.name
                it[endDate] = tournament.endDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                it[winner] = tournament.winner
                it[maxNumOfTeams] = tournament.maxNumOfTeams
                it[teamsIds] = tournament.teamsIds.toTeamsIdsString()
            }
        }
    }
}