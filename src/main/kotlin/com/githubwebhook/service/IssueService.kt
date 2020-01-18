package com.githubwebhook.service

import com.githubwebhook.dao.*
import com.githubwebhook.exception.Conflict
import com.githubwebhook.model.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.math.absoluteValue

class IssueService(private val issueDao: IssueDao, private val actorDao: ActorDao, private val eventDao: EventDao, private val assignerDao: AssignerDao, private val assigneeDao: AssigneeDao) {

    fun add(model: Issue) {
        try {


            val issue = issueDao.get(model.id)

            if (issue.isNullOrEmpty())
                issueDao.add(model)

            for (item in model.events) {

                val actors: List<Actor> = actorDao.get(item.actor?.id ?: 0)

                if (actors.isNullOrEmpty())
                    item.actor?.let { actorDao.add(it) }

                val assignees = assigneeDao.get(item.assignee?.id ?: 0)

                if (assignees.isNullOrEmpty())
                    item.assignee?.let { assigneeDao.add(it) }

                val assigners = assignerDao.get(item.assigner?.id ?: 0)

                if (assigners.isNullOrEmpty())
                    item.assigner?.let { assignerDao.add(it) }

                var event = eventDao.get(item.id)

                if (event.isNullOrEmpty())
                    eventDao.add(item, model.id)

            }
        } catch (e: ExposedSQLException) {

            if (e.message?.contains("duplicate key") == true)
                throw Conflict("")
        }

    }

    fun getEvents(id: Long): List<Event> {
        var events: List<Event> = arrayListOf()

        events = eventDao.getByIssueId(id)


        return events
    }
}

