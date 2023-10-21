package com.tablesoccer.database.user

import org.jetbrains.exposed.sql.Table

/**
 * Сущность таблицы с пользователями
 */
object UsersTable : Table(name = "users") {
    val login = UsersTable.varchar("login", 25)
    val password = UsersTable.varchar("password", 25)
    val name = UsersTable.varchar("name", 30)
    val email = UsersTable.varchar("email", 25)

    override val primaryKey = PrimaryKey(login)
}