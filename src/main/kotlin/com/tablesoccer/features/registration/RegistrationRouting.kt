package com.tablesoccer.features.registration

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.tournamentsRouting() {
    get("/register") {
        call.respondText("Hello World!")
    }
}