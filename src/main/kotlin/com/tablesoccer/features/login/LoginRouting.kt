package com.tablesoccer.features.login

import com.tablesoccer.core.exceptions.InvalidPasswordException
import com.tablesoccer.features.login.dto.request.LoginRequestDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.loginRoute() {
    val loginService by inject<LoginService>()

    post("/login") {
        val loginRequestDto = call.receive<LoginRequestDto>()

        try {
            val loginResponseDto = loginService.handleLogin(loginRequestDto = loginRequestDto)

            call.respond(loginResponseDto)
        } catch (e: Exception) {
            when (e) {
                is NotFoundException -> call.respond(HttpStatusCode.BadRequest, "User not found")
                is InvalidPasswordException -> call.respond(HttpStatusCode.BadRequest, "Incorrect password")
                else -> throw e
            }
        }
    }
}

fun Route.loginRouting() {
    loginRoute()
}