package com.tablesoccer.features.login.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val token: String,
)