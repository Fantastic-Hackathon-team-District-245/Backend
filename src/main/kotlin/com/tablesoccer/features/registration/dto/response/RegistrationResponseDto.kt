package com.tablesoccer.features.registration.dto.response

import com.tablesoccer.database.user.UserEntity
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationResponseDto(
    val email: String,
    val name: String
)

fun UserEntity.mapToRegistrationResponseDto(): RegistrationResponseDto = RegistrationResponseDto(
    email = email,
    name = name,
)