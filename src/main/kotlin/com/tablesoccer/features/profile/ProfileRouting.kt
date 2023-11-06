package com.tablesoccer.features.profile

import com.tablesoccer.features.profile.dto.request.ProfileRequestDTO
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.profileRouting() {
    val profileService by inject<ProfileService>()
    get("/profile") {



        val profileRequestDto = call.receive<ProfileRequestDTO>()
        try{
            val profileResponseDto = profileService.handleProfile(
                profileRequestDto = profileRequestDto
            )
            call.respond(profileResponseDto);
        } catch(e: Exception){

        }
    }
}
