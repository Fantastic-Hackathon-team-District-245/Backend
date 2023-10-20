package com.tablesoccer.features.profile

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.profileRouting() {
    get("/register") {
        call.respondText("Hello World!")
    }
}