package com.githubwebhook.config

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.javalin.Javalin
import io.javalin.plugin.json.JavalinJackson
import io.javalin.plugin.openapi.annotations.ContentType
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

import org.koin.core.inject
import java.text.SimpleDateFormat


class AppConfig : KoinComponent {
    private val router: RouterConfig by inject()


    fun setup(): Javalin {

        return Javalin.create()
                .also { app ->
                    app.config.defaultContentType = ContentType.JSON
                    this.configureMapper()
                    router.register(app)
                }

    }


    private fun configureMapper() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        JavalinJackson.configure(jacksonObjectMapper()
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setDateFormat(dateFormat)
                .configure(SerializationFeature.WRITE_DATES_WITH_ZONE_ID, true)
        )
    }
}