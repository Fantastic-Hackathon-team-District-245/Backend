package com.tablesoccer.features.profile

import com.tablesoccer.database.user.UsersRepository
import com.tablesoccer.features.profile.dto.request.ProfileRequestDTO
import com.tablesoccer.features.profile.dto.response.ProfileResponseDTO
import io.ktor.server.plugins.*

class ProfileService(private val usersRepository: UsersRepository) {

    fun handleProfile(profileRequestDto: ProfileRequestDTO): ProfileResponseDTO{
        val userEntity = usersRepository.findById(profileRequestDto.id)
            ?: throw NotFoundException("UserNotFound")
        return ProfileResponseDTO(
            email = userEntity.email,
            name = userEntity.name
        )
    }
}