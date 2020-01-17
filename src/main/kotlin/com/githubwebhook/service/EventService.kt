package com.githubwebhook.service

import com.githubwebhook.dao.EventDao
import com.githubwebhook.model.Event

class EventService {
    fun get(id: Long): List<Event> {
        return EventDao().get(id)
    }

//    fun getByIssueId(id: Long): List<Event> {
//        return EventDao().getByIssueId(id)
//    }

}