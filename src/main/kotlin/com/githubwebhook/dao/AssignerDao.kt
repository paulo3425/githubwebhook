package com.githubwebhook.dao

import com.githubwebhook.model.Assignee
import com.githubwebhook.model.Assignees
import com.githubwebhook.model.Assigner
import com.githubwebhook.model.Assigners
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

class AssignerDao(private val dataSource: DataSource) {
    fun get(id: Long): List<Assigner> {

        return transaction(Database.connect(dataSource)) {
            Assigners.select { Assigners.id eq id }.map {
                Assigner(
                        it[Assigners.id],
                        it[Assigners.login],
                        it[Assigners.node_id],
                        it[Assigners.avatar_url],
                        it[Assigners.gravatar_id],
                        it[Assigners.url],
                        it[Assigners.html_url],
                        it[Assigners.followers_url],
                        it[Assigners.following_url],
                        it[Assigners.gists_url],
                        it[Assigners.starred_url],
                        it[Assigners.subscriptions_url],
                        it[Assigners.organizations_url],
                        it[Assigners.repos_url],
                        it[Assigners.events_url],
                        it[Assigners.received_events_url],
                        it[Assigners.type],
                        it[Assigners.site_admin]
                )
            }
        }
    }

    fun add(assigner: Assigner) {
        transaction(Database.connect(dataSource)) {
            Assigners.insert {
                it[id] = assigner.id
                it[login] = assigner.login
                it[node_id] = assigner.node_id
                it[avatar_url] = assigner.avatar_url
                it[gravatar_id] = assigner.gravatar_id
                it[url] = assigner.url
                it[html_url] = assigner.html_url
                it[followers_url] = assigner.followers_url
                it[following_url] = assigner.following_url
                it[gists_url] = assigner.gists_url
                it[starred_url] = assigner.starred_url
                it[subscriptions_url] = assigner.subscriptions_url
                it[organizations_url] = assigner.organizations_url
                it[repos_url] = assigner.repos_url
                it[events_url] = assigner.events_url
                it[received_events_url] = assigner.received_events_url
                it[type] = assigner.type
                it[site_admin] = assigner.site_admin
            }
        }
    }
}