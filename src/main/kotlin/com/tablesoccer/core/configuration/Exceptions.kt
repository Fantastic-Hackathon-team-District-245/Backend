package com.tablesoccer.core.configuration

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

/**
 * Ловит все непойманные исключения в приложении и возвращает http статус код 500
 * Internal server error
 *
 * но сервак при этом не крашится и работает дальше
 */
fun Application.configureUncaughtExceptionHandler() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
}