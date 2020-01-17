package com.githubwebhook.service

import com.githubwebhook.model.Actors
import com.githubwebhook.model.Events
import com.githubwebhook.model.Issue
import com.githubwebhook.model.Issues
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class IssueService {

    fun add(model: Issue): Issue {

        transaction {
            Issues.insert {
                it[id] = model.id
                it[events_url]=model.events_url
            }


            for (item in model.events) {


                //var act = Actors.select(Actors.id eq item.actor?.id)

                //if(act == null)
                    Actors.insert {
                        it[id] = item.id
                        it[login] = item.actor?.login
                        it[node_id] = item.actor?.node_id
                        it[avatar_url] =item.actor?.avatar_url
                        it[gravatar_id] = item.actor?.gravatar_id
                        it[url] = item.actor?.url
                        it[html_url] = item.actor?.html_url
                        it[followers_url] = item.actor?.followers_url
                        it[following_url] = item.actor?.following_url
                        it[gists_url] = item.actor?.gists_url
                        it[starred_url] = item.actor?.starred_url
                        it[subscriptions_url] = item.actor?.subscriptions_url
                        it[organizations_url] = item.actor?.organizations_url
                        it[repos_url] = item.actor?.repos_url
                        it[events_url] = item.actor?.events_url
                        it[received_events_url] = item.actor?.received_events_url
                        it[type] = item.actor?.type
                        it[site_admin] = item.actor?.site_admin

                    }

                Events.insert {
                    it[id] = item.id
                    it[issue_id] = model.id
                    it[commit_id] = item.commit_id
                    it[commit_url] = item.commit_url
                    it[created_at] = item.created_at
                    it[event] = item.event
                    it[lock_reason] = item.lock_reason
                    it[node_id] = item.node_id
                }
            }
        }

        return model
    }
}

