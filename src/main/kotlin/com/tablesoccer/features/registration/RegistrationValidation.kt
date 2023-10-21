package com.tablesoccer.features.registration

import com.tablesoccer.features.registration.dto.request.RegistrationRequestDto
import com.tablesoccer.utils.validation.validateEmail
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*

fun Application.registrationRequestValidation() {
    install(RequestValidation) {
        validate<RegistrationRequestDto> { registrationRequestDto ->
            registrationRequestDto.email.validateEmail()
        }
    }
}