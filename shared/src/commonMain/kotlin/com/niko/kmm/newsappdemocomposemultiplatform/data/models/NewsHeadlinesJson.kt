package com.niko.kmm.newsappdemocomposemultiplatform.data.models

import kotlinx.serialization.Serializable

@Serializable
data class NewsHeadlinesJson(
    val articles: List<Article>,
)

@Serializable
data class Article(
    val title: String,
    val content: String? = "",
    val description: String? = "",
    val publishedAt: String,
    val source: Source,
    val author: String? = "",
    val url: String = "",
    val urlToImage: String? = ""
)

@Serializable
data class Source(
    val id: String? = "",
    val name: String
)