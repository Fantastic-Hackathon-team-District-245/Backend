package com.tablesoccer.database.user

import org.jetbrains.exposed.sql.Table

/**
 * Сущность таблицы с пользователями
 */
object UsersTable : Table(name = "users") {
    val email = UsersTable.text("email")
    val password = UsersTable.text("password")
    val name = UsersTable.text("name")

    override val primaryKey = PrimaryKey(email)
}