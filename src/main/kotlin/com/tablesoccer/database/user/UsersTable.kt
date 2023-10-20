package com.tablesoccer.database.user

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Сущность таблицы с пользователями
 */
object UsersTable : Table() {
    val login = UsersTable.varchar("login", 25)
    val password = UsersTable.varchar("password", 25)
    val username = UsersTable.varchar("username", 30)
    val email = UsersTable.varchar("email", 25)

    override val primaryKey = PrimaryKey(login)
}