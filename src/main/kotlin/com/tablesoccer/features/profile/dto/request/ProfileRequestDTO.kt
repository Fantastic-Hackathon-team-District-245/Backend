package com.tablesoccer.features.profile.dto.request

import com.tablesoccer.utils.serializers.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class ProfileRequestDTO (
    @Serializable(with = UUIDSerializer::class) val id: UUID
)