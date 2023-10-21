package com.tablesoccer.core.configuration

import com.tablesoccer.database.user.UsersRepository
import com.tablesoccer.features.login.LoginService
import io.ktor.server.application.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

val daoModule = module {
    singleOf(::UsersRepository)
}

val serviceModule = module {
    singleOf(::LoginService)
}

fun Application.configureKoinDI() {
    install(Koin) {
        slf4jLogger()
        modules(daoModule, serviceModule)
    }
}