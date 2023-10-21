package com.tablesoccer.features.registration

import com.tablesoccer.core.encryption.CryptUtil
import com.tablesoccer.core.exceptions.UserAlreadyExistsException
import com.tablesoccer.database.user.UserEntity
import com.tablesoccer.database.user.UsersRepository
import com.tablesoccer.features.registration.dto.request.RegistrationRequestDto
import com.tablesoccer.features.registration.dto.response.RegistrationResponseDto
import com.tablesoccer.features.registration.dto.response.mapToRegistrationResponseDto

class RegistrationService(private val usersRepository: UsersRepository) {

    fun handleRegistration(registrationRequestDto: RegistrationRequestDto): RegistrationResponseDto {
        if (usersRepository.findByEmail(email = registrationRequestDto.email) != null)
            throw UserAlreadyExistsException

        val cypheredPassword = CryptUtil.encrypt(plainText = registrationRequestDto.password)

        val newUser = UserEntity(
            password = cypheredPassword,
            email = registrationRequestDto.email,
            name = registrationRequestDto.name,
        )
        usersRepository.create(newUser)

        return newUser.mapToRegistrationResponseDto()
    }
}