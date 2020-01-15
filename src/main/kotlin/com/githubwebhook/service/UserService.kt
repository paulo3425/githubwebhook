package com.githubwebhook.service

import com.githubwebhook.model.User
import com.githubwebhook.model.UserModel
import io.javalin.http.Context
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class UserService {


    fun getAll():ArrayList<User> {

        val users: ArrayList<User> = arrayListOf()
        transaction {
            UserModel.selectAll()
                    .map {
                        users.add(
                                User(
                                        id = it[UserModel.id],
                                        name = it[UserModel.name],
                                        email = it[UserModel.email]
                                )
                        )
                    }
        }
        return users
        }
    }
