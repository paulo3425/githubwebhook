package com.githubwebhook.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

class DbConfig(dbConfig:HikariConfig) {
    private val dataSource: DataSource

    init {
        dataSource = HikariDataSource(dbConfig)
    }

    fun getDataSource(): DataSource {
        return dataSource
    }
}