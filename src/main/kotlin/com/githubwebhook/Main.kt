package com.githubwebhook

import com.githubwebhook.config.AppConfig
import com.githubwebhook.config.ModulesConfig

import org.koin.core.context.startKoin


fun main() {
    startKoin {
        modules(ModulesConfig.allModules)
    }

    AppConfig().setup().start(8080)
}