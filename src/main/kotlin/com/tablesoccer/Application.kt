package com.tablesoccer

import com.tablesoccer.configuration.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        // TODO вынести это все в конфигурацию, хз как пока что
        url = "jdbc:postgresql://localhost:5432/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "12345"
    )

    embeddedServer(
        Netty,
        port = 8080,
        module = Application::main
    ).start(wait = true)
}

fun Application.main() {
    configureKoinDI()

    configureSecurity()
    configureRouting()
    configureValidation()
    configureUncaughtExceptionHandler()
    configureSerialization()
}