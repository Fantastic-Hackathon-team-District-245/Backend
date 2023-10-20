package com.tablesoccer.features.commands

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.commandsRouting() {
    get("/tournaments") {
        call.respondText("Hello World!")
    }
}