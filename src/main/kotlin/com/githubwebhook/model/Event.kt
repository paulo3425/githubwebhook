package com.githubwebhook.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.jetbrains.exposed.sql.Table

@JsonIgnoreProperties(ignoreUnknown = true)
data class Event(
        var id: Long,
        var commit_id: String?,
        var commit_url: String?,
        var created_at: String?,
        var event: String?,
        var lock_reason: String?,
        var node_id: String?,
        var issue_id: Long,
        var actor: Actor?,
        var assignee: Assignee?,
        var assigner: Assigner?

)

object Events : Table("events") {
    val id = long("id").primaryKey()
    val issue_id = long("issue_id")
    val commit_id = varchar("commit_id",255).nullable()
    val commit_url = varchar("commit_url",255).nullable()
    val created_at = varchar("created_at",255).nullable()
    val event = varchar("event",255).nullable()
    val lock_reason = varchar("lock_reason",255).nullable()
    val node_id = varchar("node_id",255).nullable()
    val actor_id = optReference ("actor_id", Actors.id)
    val assignee_id = optReference("assignee_id", Assignees.id)
    val assigner_id = optReference("assigner_id", Assigners.id)




}