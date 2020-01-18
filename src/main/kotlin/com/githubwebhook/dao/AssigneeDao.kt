package com.githubwebhook.dao

import com.githubwebhook.model.Actor
import com.githubwebhook.model.Actors
import com.githubwebhook.model.Assignee
import com.githubwebhook.model.Assignees
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

class AssigneeDao (private val dataSource: DataSource){

    fun get(id: Long): List<Assignee> {

        return transaction(Database.connect(dataSource)) {
            Assignees.select { Assignees.id eq id }.map {
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
            }
        }
    }

    fun add(assignee: Assignee) {
        transaction(Database.connect(dataSource)) {
            Assignees.insert {
                it[id] = assignee.id
                it[login] = assignee.login
                it[node_id] = assignee.node_id
                it[avatar_url] = assignee.avatar_url
                it[gravatar_id] = assignee.gravatar_id
                it[url] = assignee.url
                it[html_url] = assignee.html_url
                it[followers_url] = assignee.followers_url
                it[following_url] = assignee.following_url
                it[gists_url] = assignee.gists_url
                it[starred_url] = assignee.starred_url
                it[subscriptions_url] = assignee.subscriptions_url
                it[organizations_url] = assignee.organizations_url
                it[repos_url] = assignee.repos_url
                it[events_url] = assignee.events_url
                it[received_events_url] = assignee.received_events_url
                it[type] = assignee.type
                it[site_admin] = assignee.site_admin
            }
        }
    }
}