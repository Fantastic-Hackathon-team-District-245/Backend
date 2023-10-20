package com.tablesoccer.database.user

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * DAO (Database access object) сущность - сущность для общения с базой данных
 */
class UsersRepository {
    fun create(userDTO: UserDTO) {
        transaction {
            UsersTable.insert {
                it[login] = userDTO.login
                it[password] = userDTO.password
                it[username] = userDTO.username
                it[email] = userDTO.email
            }
        }
    }

    fun findByLogin(login: String): UserDTO? {
        return try {
            transaction {
                val userModel = UsersTable.select { UsersTable.login.eq(login) }.single()
                UserDTO(
                    login = userModel[UsersTable.login],
                    password = userModel[UsersTable.password],
                    username = userModel[UsersTable.username],
                    email = userModel[UsersTable.email]
                )
            }
        } catch (e: Exception) {
            null
        }
    }
}