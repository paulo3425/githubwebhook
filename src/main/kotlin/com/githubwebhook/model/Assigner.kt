package com.githubwebhook.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.jetbrains.exposed.sql.Table

@JsonIgnoreProperties(ignoreUnknown = true)
data class Assigner(
        var id: Long,
        var login: String?,
        var node_id: String?,
        var avatar_url: String?,
        var gravatar_id: String?,
        var url: String?,
        var html_url: String?,
        var followers_url: String?,
        var following_url: String?,
        var gists_url: String?,
        var starred_url: String?,
        var subscriptions_url: String?,
        var organizations_url: String?,
        var repos_url: String?,
        var events_url: String?,
        var received_events_url: String?,
        var type: String?,
        var site_admin: Boolean?

)
object Assigners : Table("assigners") {
    val id = long("id").primaryKey()
    val login = varchar("login", 255).nullable()
    val node_id = varchar("node_id", 255).nullable()
    val avatar_url = varchar("avatar_url", 255).nullable()
    val gravatar_id = varchar("gravatar_id", 255).nullable()
    val url = varchar("url", 255).nullable()
    val html_url = varchar("html_url", 255).nullable()
    val followers_url = varchar("followers_url", 255).nullable()
    val following_url = varchar("following_url", 255).nullable()
    val gists_url = varchar("gists_url", 255).nullable()
    val starred_url = varchar("starred_url", 255).nullable()
    val subscriptions_url = varchar("subscriptions_url", 255).nullable()
    val organizations_url = varchar("organizations_url", 255).nullable()
    val repos_url = varchar("repos_url", 255).nullable()
    val events_url = varchar("events_url", 255).nullable()
    val received_events_url = varchar("received_events_url", 255).nullable()
    val type = varchar("type", 255).nullable()
    val site_admin = bool("site_admin").nullable()

}