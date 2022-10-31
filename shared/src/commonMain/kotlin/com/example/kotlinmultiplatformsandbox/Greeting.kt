package com.example.kotlinmultiplatformsandbox

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {
    private val platform: Platform = Platform()
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    /*
    fun greeting(): String {
        //val year = "\nThere are only ${daysUntilNewYear()} days left until New Year! 🌅"
        return "Guess what it is! > ${platform.platform.reversed()} !"
    }
    */

    @Throws(Exception::class)
    suspend fun greeting(): String {
        val rockets: List<RocketLaunch> = httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }
        return "Guess what it is! > ${platform.platform.reversed()}!" + "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀"
    }
}