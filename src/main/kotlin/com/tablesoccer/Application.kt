package com.tablesoccer

import com.tablesoccer.plugins.configureRouting
import com.tablesoccer.plugins.configureSecurity
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        // TODO вынести это все в конфигурацию, хз как пока что
        url = "jdbc:postgresql://db/playzone",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "0Iz4Ca9wdRs-dfEPnGc9gAE-ZaJyyBmT2Jc"
    )

    embeddedServer(
        Netty,
        port = 8080,
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureSecurity()
    configureRouting()
}