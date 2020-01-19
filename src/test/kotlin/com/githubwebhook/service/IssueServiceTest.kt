//package com.gitgubwebwook.service
//
//
//import com.githubwebhook.config.ModulesConfig
//import com.githubwebhook.model.*
//import jdk.internal.net.http.HttpRequestBuilderImpl
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.koin.core.context.startKoin
//import org.koin.core.context.stopKoin
//import org.koin.test.KoinTest
//import org.mockito.*
//import org.mockito.BDDMockito.*
//import java.net.URI
//import java.net.URL
//import java.net.http.HttpRequest
//import javax.servlet.http.HttpUtils
//
//
//
//
//
//class IssueServiceTest : KoinTest {
////    private val issueService: IssueService by inject()
////    private val issueDao: IssueDao by inject()
////    private val eventDao: EventDao by inject()
////    private val dataSource: DataSource by inject()
//    private lateinit var http:  URL
//
//
//
//    @Before
//    fun setUpTest() {
//        startKoin {
//            modules(ModulesConfig.allModules)
//        }
//
//
////        declareMock<DataSource>()
////        declareMock<IssueDao>()
////        declareMock<EventDao>()
////        declareMock<IssueService>()
//
//    }
//
//    @After
//    fun after() {
//        stopKoin()
//    }
//
//    @Test
//    fun addIssue() {
//
//
//        val events = mutableListOf<Event>()
//        events.add(
//                Event(1, "commit_id", "commit_url", "created_at", "event", "lock_reason", "node_id", 1,
//                        Actor(1, "login", "node_id", "avatar_url", "gravatar_id", "url", "html_url", "followers_url", "following_url", "gits_url", "starred_url", "subscriptions_url", "orgnations_url", "repos_url", "events_url", "received_url", "type", true),
//                        Assignee(1, "login", "node_id", "avatar_url", "gravatar_id", "url", "html_url", "followers_url", "following_url", "gits_url", "starred_url", "subscriptions_url", "orgnations_url", "repos_url", "events_url", "received_url", "type", true),
//                        Assigner(1, "login", "node_id", "avatar_url", "gravatar_id", "url", "html_url", "followers_url", "following_url", "gits_url", "starred_url", "subscriptions_url", "orgnations_url", "repos_url", "events_url", "received_url", "type", true)))
//
//        var issue: Issue = Issue(1, "events_url", events)
//
//
//
//
//
//        http.uri(URI("/payload")).POST(issue).build()
//
//        val response = http.(http.) <UserDTO>("/api/users", userDTO)
//
//
//        verify(issueService, Mockito.times(1)).add(any(Issue::class.java))
//
//
//    }
//
////    @Test
////    fun getEvents() {
////
////
////
////            val events = mutableListOf<Event>()
////            events.add(
////                    Event(1, "commit_id", "commit_url", "created_at", "event", "lock_reason", "node_id", 1,
////                            Actor(1, "login", "node_id", "avatar_url", "gravatar_id", "url", "html_url", "followers_url", "following_url", "gits_url", "starred_url", "subscriptions_url", "orgnations_url", "repos_url", "events_url", "received_url", "type", true),
////                            Assignee(1, "login", "node_id", "avatar_url", "gravatar_id", "url", "html_url", "followers_url", "following_url", "gits_url", "starred_url", "subscriptions_url", "orgnations_url", "repos_url", "events_url", "received_url", "type", true),
////                            Assigner(1, "login", "node_id", "avatar_url", "gravatar_id", "url", "html_url", "followers_url", "following_url", "gits_url", "starred_url", "subscriptions_url", "orgnations_url", "repos_url", "events_url", "received_url", "type", true)))
////
////
////            given(eventDao.getByIssueId(1)).willAnswer{r-> r.getArgument(0)}
////
//////            val ev = eventDao.getByIssueId(1)
////
////            val list = service.getEvents(1)
////
////            assert(!list.isNullOrEmpty())
////
////
////
////    }
//}
//
