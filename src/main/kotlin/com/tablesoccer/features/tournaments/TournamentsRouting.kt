package com.tablesoccer.features.tournaments

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.tournamentsRouting() {
    get("/tournaments") {
        call.respondText("Hello World!")
    }
}