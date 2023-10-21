package com.tablesoccer.features.registration.dto.response

import com.tablesoccer.database.user.UserEntity
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationResponseDto(
    val login: String,
    val password: String,
    val email: String,
    val name: String
)

fun UserEntity.mapToRegistrationResponseDto(): RegistrationResponseDto = RegistrationResponseDto(
    login = login,
    password = password,
    email = email,
    name = name,
)