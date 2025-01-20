package com.surivalcoding.composerecipeapp.util

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
fun createJsonHttpClient(): HttpClient =
    HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                allowTrailingComma = true
                ignoreUnknownKeys = true
            })
        }
    }
