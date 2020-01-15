package com.githubwebhook.model

import org.jetbrains.exposed.sql.Table
import java.util.*

data class User (
	val name: String,
	val email: String,
	val id: Int
)

object UserModel: Table("users") {
	val id = integer("id").primaryKey()
	val name = text("name")
	val email = text("email")

}