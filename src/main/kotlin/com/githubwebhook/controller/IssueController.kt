package com.githubwebhook.controller


import com.fasterxml.jackson.module.kotlin.readValue
import com.githubwebhook.exception.Conflict
import com.githubwebhook.model.Event
import com.githubwebhook.model.Payload
import com.githubwebhook.service.IssueService
import io.javalin.http.Context
import io.javalin.plugin.json.JavalinJackson
import java.net.URL

class IssueController(private val issueService: IssueService) {
    //private val issueService = IssueService()

    fun add(ctx: Context) {

        try {

            var payload = ctx.body<Payload>()

            payload.issue.events = JavalinJackson.getObjectMapper().readValue<List<Event>>(URL(payload.issue.events_url))

            if (payload.issue != null && !payload.issue.events.isNullOrEmpty())
                issueService.add(payload.issue)

            ctx.status(201)
        }
        catch (e: Conflict) {
            ctx.status(409)
        }
        catch (e: Exception) {
            ctx.status(500)
        }


    }

    fun getEvents(ctx: Context) {

        try {
            var events = issueService.getEvents(ctx.pathParam("id").toLong())

            if (events.isNullOrEmpty())
                ctx.status(404)
            else
                ctx.status(200)

            ctx.json(events)


        } catch (e: Exception) {
            ctx.status(500)
        }
    }


}


