package com.tablesoccer.features.registration

import com.tablesoccer.core.exceptions.UserAlreadyExistsException
import com.tablesoccer.features.registration.dto.request.RegistrationRequestDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.registerRoute() {
    val registrationService by inject<RegistrationService>()

    post("/register") {
        val registrationRequestDto = call.receive<RegistrationRequestDto>()

        try {
            val registrationResponseDto = registrationService.handleRegistration(
                registrationRequestDto = registrationRequestDto,
            )

            call.respond(registrationResponseDto)
        } catch (e: UserAlreadyExistsException) {
            call.respond(HttpStatusCode.Conflict, "User already exists")
        }
    }
}

fun Route.registrationRouting() {
    registerRoute()
}