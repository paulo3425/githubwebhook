package com.githubwebhook.dao


import com.githubwebhook.model.Actor
import com.githubwebhook.model.Issue
import com.githubwebhook.model.Issues
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

class IssueDao(private val dataSource: DataSource) {


    fun add(issue: Issue) {

        transaction(Database.connect(dataSource)) {
            Issues.insert {
                it[id] = issue.id
                it[events_url] = issue.events_url

            }
        }

    }

    fun get(id: Long): List<Issue> {

        return transaction(Database.connect(dataSource)) {
            Issues.select { Issues.id eq id }.map {
                Issue(
                        it[Issues.id],
                        it[Issues.events_url]

                )

            }
        }

    }

}