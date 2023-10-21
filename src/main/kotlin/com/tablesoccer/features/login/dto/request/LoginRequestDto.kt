package com.tablesoccer.features.login.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val login: String,
    val password: String,
)
