package com.githubwebhook

import com.githubwebhook.controller.IssueController
import com.githubwebhook.controller.UserController
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import org.jetbrains.exposed.sql.Database

fun main() {



	fun initDB() {
		val config = HikariConfig("/hikari.properties")
		config.schema = "public"
		val ds = HikariDataSource(config)
		Database.connect(ds)
	}

	//val userController = UserController


	val app = Javalin.create().apply {
		initDB()
		exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
		error(404) { ctx -> ctx.json("not found") }

	}.start(4567)



	app.routes {


		post("/payload") { ctx ->
			//print(ctx.body())
			IssueController.add(ctx)
		}

//		get("/users") { ctx ->
//			UserController.getAll(ctx)
//
//
//		}

		get("/issues/:id/events") { ctx ->
			IssueController.getEvents(ctx)
		}
//
//		get("/users/email/:email") { ctx ->
//			ctx.json(userDao.findByEmail(ctx.pathParam("email"))!!)
//		}
//
//		post("/users") { ctx ->
//			UserController.add(ctx)
//			//ctx.status(201)
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