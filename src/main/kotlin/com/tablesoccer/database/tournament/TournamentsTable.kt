package com.tablesoccer.database.tournament

import org.jetbrains.exposed.sql.Table


/**
 * сущность таблицы с туриками
 */
object TournamentsTable : Table(name = "tournaments") {
    val tournamentID = TournamentsTable.varchar("name", 30)
    val name = TournamentsTable.varchar("name", 40)
    val startDate = TournamentsTable.varchar("startDate", 10)
    val endDate = TournamentsTable.varchar("endDate", 10)
    val status = TournamentsTable.varchar("status", 9)
    val maxNumOfTeams = TournamentsTable.integer("maxNumOfTeams")
    val winner = TournamentsTable.varchar("winner", 25)
    val teamsIds = TournamentsTable.text("teamsIds")


    override val primaryKey = PrimaryKey(tournamentID)
}