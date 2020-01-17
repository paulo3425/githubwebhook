package com.githubwebhook.dao

import com.githubwebhook.model.Event
import com.githubwebhook.model.Events
import org.jetbrains.exposed.sql.insert

class EventDao {

    fun add(event: Event, issueID: Long) {

        Events.insert {
            it[id] = event.id
            it[issue_id] = issueID
            it[commit_id] = event.commit_id
            it[commit_url] = event.commit_url
            it[created_at] = event.created_at
            it[Events.event] = event.event
            it[lock_reason] = event.lock_reason
            it[node_id] = event.node_id
        }
    }
}