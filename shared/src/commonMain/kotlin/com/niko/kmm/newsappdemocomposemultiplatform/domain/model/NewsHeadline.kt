package com.niko.kmm.newsappdemocomposemultiplatform.domain.model

data class NewsHeadline(
    var author: String,
    var content: String,
    val title: String,
    val description: String,
    val source: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
)