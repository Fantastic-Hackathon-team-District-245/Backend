package com.tablesoccer.utils.validation

import io.ktor.server.plugins.requestvalidation.*

/**
 * @return валидный email или нет.
 */
fun String.validateEmail(): ValidationResult {
    return if (Patterns.EMAIL_REGEXP.matches(this)) {
        ValidationResult.Valid
    } else {
        ValidationResult.Invalid("Invalid email")
    }
}