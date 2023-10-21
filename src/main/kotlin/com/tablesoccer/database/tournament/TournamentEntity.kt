package com.tablesoccer.database.tournament

import java.time.LocalDate


enum class TournamentStatus {
    PLANNED,
    ACTIVE,
    COMPLETED,
    CANCELED
}
class TournamentEntity (
    val tournamentID: String,
    val name: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val teamsIds: List<String>, //id каждой команды
    val status: TournamentStatus,
    val winner: String,
    val maxNumOfTeams: Int //максимальое число команд-участников

)

private const val TEAMS_IDS_SEPARATOR = ","

fun List<String>.toTeamsIdsString():String = joinToString(separator = TEAMS_IDS_SEPARATOR)

fun String.toTeamsIdsList(): List<String> = split(TEAMS_IDS_SEPARATOR)

