package com.tablesoccer.features.login

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.loginRouting() {
    get("/tournaments") {
        call.respondText("Hello World!")
    }
}