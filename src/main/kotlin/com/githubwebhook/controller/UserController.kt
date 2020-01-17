package com.githubwebhook.controller


import com.githubwebhook.model.User
import com.githubwebhook.service.UserService
import io.javalin.http.Context
import org.jetbrains.exposed.exceptions.ExposedSQLException

object UserController {

    private val userService = UserService()

    fun add(ctx: Context) {

        try {
            val user = userService.add(ctx.body<User>())
            ctx.status(201)
        } catch (e: ExposedSQLException) {
            ctx.status(500)
        }


    }

    fun getAll(ctx: Context) {

        try {
            var users = userService.getAll()

            if (users.isNullOrEmpty())
                ctx.status(404)
            else
                ctx.status(200)

            ctx.json(users)
        } catch (e: ExposedSQLException) {
            ctx.status(500)
        }
    }

    fun getOne(ctx: Context) {
    }

    fun update(ctx: Context) {
    }

    fun delete(ctx: Context) {
    }

}