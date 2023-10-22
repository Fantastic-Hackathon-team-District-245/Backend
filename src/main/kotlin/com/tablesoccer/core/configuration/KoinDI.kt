package com.tablesoccer.core.configuration

import com.tablesoccer.database.tournament.TournamentsRepository
import com.tablesoccer.database.user.UsersRepository
import com.tablesoccer.features.login.LoginService
import com.tablesoccer.features.registration.RegistrationService
import com.tablesoccer.features.tournaments.CreateTournamentService
import io.ktor.server.application.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val daoModule = module {
    singleOf(::UsersRepository)
    singleOf(::TournamentsRepository)
}

val serviceModule = module {
    singleOf(::LoginService)
    singleOf(::RegistrationService)
    singleOf(::CreateTournamentService)
}

fun Application.configureKoinDI() {
    install(Koin) {
        slf4jLogger()
        modules(daoModule, serviceModule)
    }
}