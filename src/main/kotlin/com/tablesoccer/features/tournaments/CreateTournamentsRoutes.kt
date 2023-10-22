package com.tablesoccer.features.tournaments

import com.tablesoccer.core.exceptions.InvalidStartDateException
import com.tablesoccer.features.tournaments.dto.request.CreateTournamentRequestDTO
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.createTournamentRoute() {
    val createTournamentService by inject<CreateTournamentService>()

    post("/createTournament") {
        val createTournamentRequestDto = call.receive<CreateTournamentRequestDTO>()


        try{
            val createTournamentResponseDto = createTournamentService.handleCreateTournament(
                createTournamentRequestDto = createTournamentRequestDto
            )

            call.respond(createTournamentResponseDto)
        } catch(e: InvalidStartDateException){

        } catch (e: InvalidStartDateException){

        }
    }
}

fun Route.createTournamentRouting(){
    createTournamentRoute()
}