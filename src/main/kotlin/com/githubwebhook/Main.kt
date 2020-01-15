package com.githubwebhook

import com.githubwebhook.dao.UserDao
import com.githubwebhook.model.User
import com.githubwebhook.service.UserService
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.delete
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.patch
import io.javalin.apibuilder.ApiBuilder.post
import org.jetbrains.exposed.sql.Database

fun main() {

	fun initDB() {
		val config = HikariConfig("/hikari.properties")
		config.schema = "public"
		val ds = HikariDataSource(config)
		Database.connect(ds)
	}

	val userService = UserService()

	val app = Javalin.create().apply {
		initDB()
		exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
		error(404) { ctx -> ctx.json("not found") }
	}.start(7000)

	app.routes {


		get("/users") { ctx ->
			ctx.json(userService.getAll())
		}

//		get("/users/:user-id") { ctx ->
//			ctx.json(userDao.findById(ctx.pathParam("user-id").toInt())!!)
//		}
//
//		get("/users/email/:email") { ctx ->
//			ctx.json(userDao.findByEmail(ctx.pathParam("email"))!!)
//		}
//
//		post("/users") { ctx ->
//			val user = ctx.body<User>()
//			userDao.save(name = user.name, email = user.email)
//			ctx.status(201)
//		}
//
//		patch("/users/:user-id") { ctx ->
//			val user = ctx.body<User>()
//			userDao.update(
//				id = ctx.pathParam("user-id").toInt(),
//				user = user
//			)
//			ctx.status(204)
//		}
//
//		delete("/users/:user-id") { ctx ->
//			userDao.delete(ctx.pathParam("user-id").toInt())
//			ctx.status(204)
//		}

	}
}