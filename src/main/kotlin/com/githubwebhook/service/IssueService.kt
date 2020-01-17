package com.githubwebhook.service

import com.githubwebhook.dao.ActorDao
import com.githubwebhook.dao.EventDao
import com.githubwebhook.dao.IssueDao
import com.githubwebhook.model.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.math.absoluteValue

class IssueService {

    fun add(model: Issue): Issue {

        transaction {

            IssueDao().add(model)

            for (item in model.events) {

                var actorId: Long = item.actor?.id ?: 0
                val actors: List<Actor> = ActorDao().get(actorId)

                if (actors.isNullOrEmpty())
                    item.actor?.let { ActorDao().add(it) }

                EventDao().add(item, model.id)

            }
        }

        return model
    }
}

