package com.tablesoccer.database.team

import java.util.*

class TeamModel(
    val teamId: UUID,
    val teamName: String,
    val firstParticipantId: UUID,
    val secondParticipantId: UUID,
)