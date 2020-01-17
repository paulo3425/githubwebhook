package com.githubwebhook.service

import com.githubwebhook.dao.*
import com.githubwebhook.model.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.math.absoluteValue

class IssueService {

    fun add(model: Issue) {

        transaction {

            val issue = IssueDao().get(model.id)

            if (issue.isNullOrEmpty())
                IssueDao().add(model)

            for (item in model.events) {

                val actors: List<Actor> = ActorDao().get(item.actor?.id ?: 0)

                if (actors.isNullOrEmpty())
                    item.actor?.let { ActorDao().add(it) }

                val assignees = AssigneeDao().get(item.assignee?.id ?: 0)

                if (assignees.isNullOrEmpty())
                    item.assignee?.let { AssigneeDao().add(it) }

                val assigners = AssignerDao().get(item.assigner?.id ?: 0)

                if (assigners.isNullOrEmpty())
                    item.assigner?.let { AssignerDao().add(it) }

                var event = EventDao().get(item.id)

                if (event.isNullOrEmpty())
                    EventDao().add(item, model.id)

            }
        }

    }

    fun getEvents(id: Long): List<Event> {
        var events: List<Event> = arrayListOf()

        transaction {
            events = EventDao().getByIssueId(id)
        }

        return events
    }
}

