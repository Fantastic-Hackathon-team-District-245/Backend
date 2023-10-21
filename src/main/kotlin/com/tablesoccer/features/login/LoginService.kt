package com.tablesoccer.features.login

import com.tablesoccer.core.encryption.CryptUtil
import com.tablesoccer.core.exceptions.InvalidPasswordException
import com.tablesoccer.database.user.UsersRepository
import com.tablesoccer.features.login.dto.request.LoginRequestDto
import com.tablesoccer.features.login.dto.response.LoginResponseDto
import io.ktor.server.plugins.*

class LoginService(private val usersRepository: UsersRepository) {

    fun handleLogin(loginRequestDto: LoginRequestDto): LoginResponseDto {
        val userEntity = usersRepository.findByEmail(email = loginRequestDto.email)
            ?: throw NotFoundException("User not found")

        if (!CryptUtil.compare(plainText = loginRequestDto.password, cipherText = userEntity.password)) {
            throw InvalidPasswordException
        }

        //TODO добавить дешифрацию пароля так как в бд он должен быть зашифрован
        return LoginResponseDto(
            token = "123123",
        )
    }
}