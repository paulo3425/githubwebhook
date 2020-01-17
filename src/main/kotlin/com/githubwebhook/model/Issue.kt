package com.githubwebhook.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonRootName
import com.githubwebhook.model.UserModel.primaryKey
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

@JsonRootName(value = "issue")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Issue(
        val id: Long,
        val events_url: String,
        var events: List<Event> = arrayListOf()
)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Payload(
        val issue: Issue
)



object Issues: Table("issues") {
    val id = long("id").primaryKey()
    val events_url= text("events_url")
}
