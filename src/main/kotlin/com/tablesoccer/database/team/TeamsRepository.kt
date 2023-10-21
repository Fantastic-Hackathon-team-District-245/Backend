package com.tablesoccer.database.team

import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class TeamsRepository {
    fun create(teamModel: TeamModel): UUID {
        return transaction {
            TeamsTable.insertAndGetId {
                it[TeamsTable.teamName] = teamModel.teamName
                it[TeamsTable.firstParticipantId] = teamModel.firstParticipantId
                it[TeamsTable.secondParticipantId] = teamModel.secondParticipantId
            }.value
        }
    }

}