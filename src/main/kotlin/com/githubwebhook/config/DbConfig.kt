package com.githubwebhook.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

class DbConfig() {
    private val dataSource: DataSource

    init {
        var config: HikariConfig = HikariConfig()

        config.jdbcUrl =System.getenv("dataSource.url")
        config.username =System.getenv("dataSource.user")
        config.password =  System.getenv("dataSource.password")
        config.driverClassName =  System.getenv("dataSource.dataSourceClassName")

        dataSource = HikariDataSource(config)
    }

    fun getDataSource(): DataSource {
        return dataSource
    }
}