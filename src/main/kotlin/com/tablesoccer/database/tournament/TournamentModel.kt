package com.tablesoccer.database.tournament

import java.time.LocalDate
import java.util.UUID


enum class TournamentStatus {
    PLANNED,
    ACTIVE,
    COMPLETED,
    CANCELED
}

class TournamentModel(
    val tournamentId:UUID,
    val name: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val teamsIds: List<UUID>, //id каждой команды
    val status: TournamentStatus,
    val winner: String,
    val maxNumOfTeams: Int //максимальое число команд-участников

)

private const val TEAMS_IDS_SEPARATOR = ","

fun List<UUID>.toTeamsIdsString(): String = joinToString(separator = TEAMS_IDS_SEPARATOR)

fun String.toTeamsIdsListUUID(): List<UUID> = split(TEAMS_IDS_SEPARATOR).map { UUID.fromString(it) }

