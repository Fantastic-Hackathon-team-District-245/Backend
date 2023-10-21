package com.tablesoccer.database.user

import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * DAO (Database access object) сущность - сущность для общения с базой данных
 */
class UsersRepository {
    fun create(userEntity: UserEntity) {
        transaction {
            UsersTable.insert {
                it[password] = userEntity.password
                it[name] = userEntity.name
                it[email] = userEntity.email
            }
        }
    }

    fun findByEmail(email: String): UserEntity? {
        return try {
            transaction {
                val userModel = UsersTable.select { UsersTable.email.eq(email) }.single()
                UserEntity(
                    password = userModel[UsersTable.password],
                    name = userModel[UsersTable.name],
                    email = userModel[UsersTable.email],
                )
            }
        } catch (e: Exception) {
            null
        }
    }
}