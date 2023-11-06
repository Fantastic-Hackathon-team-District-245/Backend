package com.tablesoccer.database.user

import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

/**
 * DAO (Database access object) сущность - сущность для общения с базой данных
 */
class UsersRepository {

    /**
     * Создает пользователя и возвращает его UUID
     */
    fun create(
        email: String,
        password: String,
        name: String,
    ): UUID {
        return transaction {
            UsersTable.insertAndGetId {
                it[UsersTable.email] = email
                it[UsersTable.password] = password
                it[UsersTable.name] = name
            }.value
        }
    }

    fun findByEmail(email: String): UserModel? {
        return try {
            transaction {
                val userModel = UsersTable.select { UsersTable.email.eq(email) }.single()
                UserModel(
                    id = userModel[UsersTable.id].value,
                    email = userModel[UsersTable.email],
                    password = userModel[UsersTable.password],
                    name = userModel[UsersTable.name],
                )
            }
        } catch (e: Exception) {
            null
        }
    }

    fun findById(userId: UUID): UserModel? {
        return try {
            transaction {
                val userModel = UsersTable.select { UsersTable.id.eq(userId) }.single()
                UserModel(
                    id = userModel[UsersTable.id].value,
                    email = userModel[UsersTable.email],
                    password = userModel[UsersTable.password],
                    name = userModel[UsersTable.name],
                )
            }
        } catch (e: Exception) {
            null
        }
    }
}