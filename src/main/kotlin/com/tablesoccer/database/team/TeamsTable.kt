package com.tablesoccer.database.team

import org.jetbrains.exposed.dao.id.UUIDTable


/**
 * Сущность таблицы с пользователями
 */
object TeamsTable : UUIDTable(name = "teams") {
    val teamName = TeamsTable.text("teamName")
    val firstParticipantId = TeamsTable.uuid("firstParticipantId")
    val secondParticipantId = TeamsTable.uuid("secondParticipantId")
}