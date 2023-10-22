package com.tablesoccer.features.tournaments

import com.tablesoccer.database.tournament.TournamentsRepository
import com.tablesoccer.features.tournaments.dto.request.CreateTournamentRequestDTO
import com.tablesoccer.features.tournaments.dto.response.CreateTournamentResponseDTO

class CreateTournamentService(private val tournamentsRepository: TournamentsRepository) {
    fun handleCreateTournament(createTournamentRequestDto: CreateTournamentRequestDTO): CreateTournamentResponseDTO {
        val tournamentId = tournamentsRepository.create(
            name = createTournamentRequestDto.name,
            startDate = createTournamentRequestDto.startDate,
            endDate = createTournamentRequestDto.endDate,
            status = createTournamentRequestDto.status,
            winner = createTournamentRequestDto.winner,
            maxNumOfTeams = createTournamentRequestDto.maxNumOfTeams
        )

        return CreateTournamentResponseDTO(tournamentId = tournamentId)
    }
}