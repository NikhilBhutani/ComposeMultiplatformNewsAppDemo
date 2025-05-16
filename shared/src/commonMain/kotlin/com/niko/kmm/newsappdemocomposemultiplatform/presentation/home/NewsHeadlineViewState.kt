package com.niko.kmm.newsappdemocomposemultiplatform.presentation.home

import androidx.compose.runtime.Immutable

@Immutable
data class NewsHeadlineViewState(
    val newsHeadlinesUi: List<NewsHeadlineUI> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorString: String = ""
)

@Immutable
data class NewsHeadlineUI(
    val author: String,
    val content: String,
    val title: String,
    val description: String,
    val source: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
)