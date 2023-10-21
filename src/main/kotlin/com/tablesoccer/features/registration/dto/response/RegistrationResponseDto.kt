package com.tablesoccer.features.registration.dto.response

import com.tablesoccer.utils.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class RegistrationResponseDto(
    @Serializable(with = UUIDSerializer::class) val userId: UUID,
)