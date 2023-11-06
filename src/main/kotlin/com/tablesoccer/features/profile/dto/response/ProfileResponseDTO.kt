package com.tablesoccer.features.profile.dto.response

import kotlinx.serialization.Serializable

@Serializable
class ProfileResponseDTO (
    val email: String,
    val name: String
)