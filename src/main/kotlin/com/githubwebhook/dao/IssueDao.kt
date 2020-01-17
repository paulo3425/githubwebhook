package com.githubwebhook.dao


import com.githubwebhook.model.Issue
import com.githubwebhook.model.Issues
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class IssueDao {


    fun add(issue: Issue) {

        Issues.insert {
            it[id] = issue.id
            it[events_url] = issue.events_url

        }

    }
}