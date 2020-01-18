package com.githubwebhook.config

import com.githubwebhook.controller.IssueController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder

import org.koin.core.KoinComponent
import io.javalin.apibuilder.ApiBuilder.path
import io.javalin.apibuilder.ApiBuilder.post

class RouterConfig(private val issueController: IssueController) : KoinComponent {

    fun register(app: Javalin) {

        app.routes {
//            path("/payload") {
//                post(issueController::add)
//            }

            ApiBuilder.post("/payload") { ctx ->
                issueController.add(ctx)
            }

//            path("/issues/:id/events") {
//                post(issueController::getEvents)
//            }

            ApiBuilder.get("/issues/:id/events") { ctx ->
                issueController.getEvents(ctx)
            }


        }

    }
}