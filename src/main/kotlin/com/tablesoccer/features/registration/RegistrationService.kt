package com.tablesoccer.features.registration

import com.tablesoccer.core.encryption.CryptUtil
import com.tablesoccer.core.exceptions.UserAlreadyExistsException
import com.tablesoccer.database.user.UsersRepository
import com.tablesoccer.features.registration.dto.request.RegistrationRequestDto
import com.tablesoccer.features.registration.dto.response.RegistrationResponseDto

class RegistrationService(private val usersRepository: UsersRepository) {

    fun handleRegistration(registrationRequestDto: RegistrationRequestDto): RegistrationResponseDto {
        if (usersRepository.findByEmail(email = registrationRequestDto.email) != null)
            throw UserAlreadyExistsException

        val cypheredPassword = CryptUtil.encrypt(plainText = registrationRequestDto.password)

        val userId = usersRepository.create(
            password = cypheredPassword,
            email = registrationRequestDto.email,
            name = registrationRequestDto.name,
        )

        return RegistrationResponseDto(userId = userId)
    }
}