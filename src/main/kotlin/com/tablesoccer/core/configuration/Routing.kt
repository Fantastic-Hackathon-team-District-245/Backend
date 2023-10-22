package com.tablesoccer.core.configuration

import com.tablesoccer.features.commands.commandsRouting
import com.tablesoccer.features.login.loginRouting
import com.tablesoccer.features.profile.profileRouting
import com.tablesoccer.features.registration.registrationRouting
import com.tablesoccer.features.tournaments.TournamentRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        commandsRouting()
        loginRouting()
        profileRouting()
        registrationRouting()
        TournamentRouting()
    }
}
