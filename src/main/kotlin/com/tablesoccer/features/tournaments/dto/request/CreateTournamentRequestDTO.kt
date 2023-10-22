package com.tablesoccer.features.tournaments.dto.request
import LocalDateSerializer
import com.tablesoccer.database.tournament.TournamentStatus
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
class CreateTournamentRequestDTO (
    val name: String,
    @Serializable(with = LocalDateSerializer::class) val startDate: LocalDate,
    @Serializable(with = LocalDateSerializer::class) val endDate: LocalDate,
    val status: TournamentStatus,
    val winner: String,
    val maxNumOfTeams: Int
)
