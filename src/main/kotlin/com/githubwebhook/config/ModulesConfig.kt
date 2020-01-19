package com.githubwebhook.config

import com.githubwebhook.controller.IssueController
import com.githubwebhook.dao.*
import com.githubwebhook.service.IssueService
import com.zaxxer.hikari.HikariConfig
import org.koin.dsl.bind
import org.koin.dsl.module

object ModulesConfig {
    private val issueModule = module {
        single { IssueController(get()) }
        single { IssueService(get(), get(), get(), get(), get()) }
        single { IssueDao(get()) }
        single { EventDao(get()) }
        single { AssignerDao(get()) }
        single { AssigneeDao(get()) }
        single { ActorDao(get()) }

    }

    private val configModule = module {
        single { AppConfig() }
        single {

            DbConfig().getDataSource()
        }
        single { RouterConfig(get()) }
    }

    internal val allModules = listOf(ModulesConfig.configModule, ModulesConfig.issueModule)
}