package com.tablesoccer.features.registration

import com.tablesoccer.database.user.UserEntity
import com.tablesoccer.database.user.UsersRepository
import com.tablesoccer.features.registration.dto.request.RegistrationRequestDto
import com.tablesoccer.features.registration.dto.response.mapToRegistrationResponseDto
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.registerRoute() {
    val usersRepository by inject<UsersRepository>()

    post("/register") {
        val registrationRequestDto = call.receive<RegistrationRequestDto>()

        val newUser = UserEntity(
            login = registrationRequestDto.login,
            password = registrationRequestDto.password,
            email = registrationRequestDto.email,
            name = registrationRequestDto.name,
        )
        usersRepository.create(newUser)

        // TODO добавить красивые ошикби??
        call.respond(newUser.mapToRegistrationResponseDto())
    }
}

fun Route.registrationRouting() {
    registerRoute()
}