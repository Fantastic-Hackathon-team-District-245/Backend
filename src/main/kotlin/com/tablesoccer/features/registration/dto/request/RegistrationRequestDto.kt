package com.tablesoccer.features.registration.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequestDto(
    val email: String,
    val password: String,
    val name: String,
)
