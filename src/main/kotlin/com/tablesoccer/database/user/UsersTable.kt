package com.tablesoccer.database.user

import org.jetbrains.exposed.dao.id.UUIDTable

/**
 * Сущность таблицы с пользователями
 */
object UsersTable : UUIDTable(name = "users") {
    val email = UsersTable.text("email").uniqueIndex()
    val password = UsersTable.text("password")
    val name = UsersTable.text("name")
}