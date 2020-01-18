package com.githubwebhook.dao

import com.githubwebhook.model.Actor
import com.githubwebhook.model.Actors
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

class ActorDao(private val dataSource: DataSource) {
    fun get(id: Long): List<Actor> {

        return transaction(Database.connect(dataSource)) {
            Actors.select { Actors.id eq id }.map {
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
            }
        }
    }

    fun add(actor: Actor) {
        transaction(Database.connect(dataSource)) {
            Actors.insert {
                it[id] = actor.id
                it[login] = actor.login
                it[node_id] = actor.node_id
                it[avatar_url] = actor.avatar_url
                it[gravatar_id] = actor.gravatar_id
                it[url] = actor.url
                it[html_url] = actor.html_url
                it[followers_url] = actor.followers_url
                it[following_url] = actor.following_url
                it[gists_url] = actor.gists_url
                it[starred_url] = actor.starred_url
                it[subscriptions_url] = actor.subscriptions_url
                it[organizations_url] = actor.organizations_url
                it[repos_url] = actor.repos_url
                it[events_url] = actor.events_url
                it[received_events_url] = actor.received_events_url
                it[type] = actor.type
                it[site_admin] = actor.site_admin

            }
        }
    }
}