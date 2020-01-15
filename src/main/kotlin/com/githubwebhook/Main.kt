package com.githubwebhook

import com.githubwebhook.controller.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.plugin.openapi.OpenApiOptions
import io.javalin.plugin.openapi.OpenApiPlugin
import io.javalin.plugin.openapi.ui.ReDocOptions
import io.javalin.plugin.openapi.ui.SwaggerOptions
import io.swagger.v3.oas.models.info.Info
import com.githubwebhook.dao.UserDao
import com.githubwebhook.model.User

fun main() {

  val userDao = UserDao()

    val app = Javalin.create().apply {
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start(7000)

    app.routes {

        get("/users") { ctx ->
            ctx.json(userDao.users)
        }

        get("/users/:user-id") { ctx ->
            ctx.json(userDao.findById(ctx.pathParam("user-id").toInt())!!)
        }

        get("/users/email/:email") { ctx ->
            ctx.json(userDao.findByEmail(ctx.pathParam("email"))!!)
        }

        post("/users") { ctx ->
            val user = ctx.body<User>()
            userDao.save(name = user.name, email = user.email)
            ctx.status(201)
        }

        patch("/users/:user-id") { ctx ->
            val user = ctx.body<User>()
            userDao.update(
                    id = ctx.pathParam("user-id").toInt(),
                    user = user
            )
            ctx.status(204)
        }

        delete("/users/:user-id") { ctx ->
            userDao.delete(ctx.pathParam("user-id").toInt())
            ctx.status(204)
        }

    }
}