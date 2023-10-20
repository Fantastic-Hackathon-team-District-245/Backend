package com.tablesoccer.plugins

import com.tablesoccer.features.commands.commandsRouting
import com.tablesoccer.features.login.loginRouting
import com.tablesoccer.features.profile.profileRouting
import com.tablesoccer.features.registration.registrationRouting
import com.tablesoccer.features.tournaments.tournamentsRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        commandsRouting()
        loginRouting()
        profileRouting()
        registrationRouting()
        tournamentsRouting()
    }
}
