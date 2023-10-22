package com.tablesoccer.database.tournament

import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.javatime.date


/**
 * сущность таблицы с туриками
 */
object TournamentsTable : UUIDTable(name = "tournaments") {
    val name = TournamentsTable.text("name")
    val startDate = TournamentsTable.date("startDate")
    val endDate = TournamentsTable.date("endDate")
    val status = TournamentsTable.text("status")
    val maxNumOfTeams = TournamentsTable.integer("maxNumOfTeams")
    val winner = TournamentsTable.text("winner")
    val teamsIds = TournamentsTable.text("teamsIds")

}