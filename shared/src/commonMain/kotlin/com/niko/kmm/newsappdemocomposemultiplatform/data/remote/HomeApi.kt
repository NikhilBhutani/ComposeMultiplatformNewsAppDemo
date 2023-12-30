package com.niko.kmm.newsappdemocomposemultiplatform.data.remote


import com.niko.kmm.newsappdemocomposemultiplatform.data.models.NewsHeadlinesJson
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter

class HomeApi(
    private val client: HttpClient,
) : KtorApi() {

    companion object {
        const val HEADLINE_ENDPOINT = "top-headlines"
    }

    suspend fun fetchHeadlines(): NewsHeadlinesJson =
        try {
            client.get("$BASE_URL/$HEADLINE_ENDPOINT") {
                header("x-api-key", API_KEY)
                parameter("country", "us")
                parameter("pageSize", 20)
                parameter("page", 1)

            }.body()
        } catch (exception: Exception) {
            throw exception
        }
}