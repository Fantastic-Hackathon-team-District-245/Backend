package com.tablesoccer.core.configuration

import com.tablesoccer.features.registration.registrationRequestValidation
import io.ktor.server.application.*

fun Application.configureValidation() {
    registrationRequestValidation()
}