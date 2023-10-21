package com.tablesoccer.database.user

import java.util.*

class UserModel(
    val id: UUID,
    val password: String,
    val email: String,
    val name: String
)