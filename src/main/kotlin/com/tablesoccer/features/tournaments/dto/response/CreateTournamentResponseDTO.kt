package com.tablesoccer.features.tournaments.dto.response

import com.tablesoccer.utils.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class CreateTournamentResponseDTO (
    @Serializable(with = UUIDSerializer::class) val tournamentId: UUID
)
