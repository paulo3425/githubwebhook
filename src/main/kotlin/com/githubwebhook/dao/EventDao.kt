package com.githubwebhook.dao

import com.githubwebhook.model.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

class EventDao(private val dataSource: DataSource) {

    fun add(event: Event, issueID: Long) {
        transaction(Database.connect(dataSource)) {
            Events.insert {
                it[id] = event.id
                it[actor_id] = event.actor?.id
                it[assignee_id] = event.assignee?.id
                it[assigner_id] = event.assigner?.id
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

    fun get(id: Long): List<Event> {


        return transaction(Database.connect(dataSource)) {
            (Events leftJoin Actors leftJoin Assignees leftJoin Assigners)
                    .select {
                        Events.actor_id eq Actors.id
                        Events.assignee_id eq Assignees.id
                        Events.assigner_id eq Assignees.id
                        Events.id eq id
                    }.map {
                        Event(
                                it[Events.id],
                                it[Events.commit_id],
                                it[Events.commit_url],
                                it[Events.created_at],
                                it[Events.event],
                                it[Events.lock_reason],
                                it[Events.node_id],
                                it[Events.issue_id],
                                if (it[Actors.id] != null)
                                    Actor(
                                            it[Actors.id],
                                            it[Actors.login],
                                            it[Actors.node_id],
                                            it[Actors.avatar_url],
                                            it[Actors.gravatar_id],
                                            it[Actors.url],
                                            it[Actors.html_url],
                                            it[Actors.followers_url],
                                            it[Actors.following_url],
                                            it[Actors.gists_url],
                                            it[Actors.starred_url],
                                            it[Actors.subscriptions_url],
                                            it[Actors.organizations_url],
                                            it[Actors.repos_url],
                                            it[Actors.events_url],
                                            it[Actors.received_events_url],
                                            it[Actors.type],
                                            it[Actors.site_admin]
                                    )
                                else
                                    null
                                ,
                                if (it[Assignees.id] != null)
                                    Assignee(
                                            it[Assignees.id],
                                            it[Assignees.login],
                                            it[Assignees.node_id],
                                            it[Assignees.avatar_url],
                                            it[Assignees.gravatar_id],
                                            it[Assignees.url],
                                            it[Assignees.html_url],
                                            it[Assignees.followers_url],
                                            it[Assignees.following_url],
                                            it[Assignees.gists_url],
                                            it[Assignees.starred_url],
                                            it[Assignees.subscriptions_url],
                                            it[Assignees.organizations_url],
                                            it[Assignees.repos_url],
                                            it[Assignees.events_url],
                                            it[Assignees.received_events_url],
                                            it[Assignees.type],
                                            it[Assignees.site_admin]
                                    )
                                else
                                    null
                                ,
                                if (it[Assignees.id] != null)
                                    Assigner(
                                            it[Assignees.id],
                                            it[Assignees.login],
                                            it[Assignees.node_id],
                                            it[Assignees.avatar_url],
                                            it[Assignees.gravatar_id],
                                            it[Assignees.url],
                                            it[Assignees.html_url],
                                            it[Assignees.followers_url],
                                            it[Assignees.following_url],
                                            it[Assignees.gists_url],
                                            it[Assignees.starred_url],
                                            it[Assignees.subscriptions_url],
                                            it[Assignees.organizations_url],
                                            it[Assignees.repos_url],
                                            it[Assignees.events_url],
                                            it[Assignees.received_events_url],
                                            it[Assignees.type],
                                            it[Assignees.site_admin]
                                    )
                                else
                                    null
                        )
                    }
        }
    }

    fun getByIssueId(id: Long): List<Event> {
        return transaction(Database.connect(dataSource)) {
            (Events leftJoin Actors leftJoin Assignees leftJoin Assigners)
                    .select {
                        Events.actor_id eq Actors.id
                        Events.assignee_id eq Assignees.id
                        Events.assigner_id eq Assignees.id
                        Events.issue_id eq id
                    }.map {
                        Event(
                                it[Events.id],
                                it[Events.commit_id],
                                it[Events.commit_url],
                                it[Events.created_at],
                                it[Events.event],
                                it[Events.lock_reason],
                                it[Events.node_id],
                                it[Events.issue_id],
                                if (it[Actors.id] != null)
                                    Actor(
                                            it[Actors.id],
                                            it[Actors.login],
                                            it[Actors.node_id],
                                            it[Actors.avatar_url],
                                            it[Actors.gravatar_id],
                                            it[Actors.url],
                                            it[Actors.html_url],
                                            it[Actors.followers_url],
                                            it[Actors.following_url],
                                            it[Actors.gists_url],
                                            it[Actors.starred_url],
                                            it[Actors.subscriptions_url],
                                            it[Actors.organizations_url],
                                            it[Actors.repos_url],
                                            it[Actors.events_url],
                                            it[Actors.received_events_url],
                                            it[Actors.type],
                                            it[Actors.site_admin]
                                    )
                                else
                                    null
                                ,
                                if (it[Assignees.id] != null)
                                    Assignee(
                                            it[Assignees.id],
                                            it[Assignees.login],
                                            it[Assignees.node_id],
                                            it[Assignees.avatar_url],
                                            it[Assignees.gravatar_id],
                                            it[Assignees.url],
                                            it[Assignees.html_url],
                                            it[Assignees.followers_url],
                                            it[Assignees.following_url],
                                            it[Assignees.gists_url],
                                            it[Assignees.starred_url],
                                            it[Assignees.subscriptions_url],
                                            it[Assignees.organizations_url],
                                            it[Assignees.repos_url],
                                            it[Assignees.events_url],
                                            it[Assignees.received_events_url],
                                            it[Assignees.type],
                                            it[Assignees.site_admin]
                                    )
                                else
                                    null
                                ,
                                if (it[Assignees.id] != null)
                                    Assigner(
                                            it[Assignees.id],
                                            it[Assignees.login],
                                            it[Assignees.node_id],
                                            it[Assignees.avatar_url],
                                            it[Assignees.gravatar_id],
                                            it[Assignees.url],
                                            it[Assignees.html_url],
                                            it[Assignees.followers_url],
                                            it[Assignees.following_url],
                                            it[Assignees.gists_url],
                                            it[Assignees.starred_url],
                                            it[Assignees.subscriptions_url],
                                            it[Assignees.organizations_url],
                                            it[Assignees.repos_url],
                                            it[Assignees.events_url],
                                            it[Assignees.received_events_url],
                                            it[Assignees.type],
                                            it[Assignees.site_admin]
                                    )
                                else
                                    null
                        )
                    }
        }
    }

}