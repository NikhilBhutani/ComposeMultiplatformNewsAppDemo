package com.niko.kmm.newsappdemocomposemultiplatform.domain.repository

import com.niko.kmm.newsappdemocomposemultiplatform.domain.model.NewsHeadline

interface GetNewsRepository {
    suspend fun getHeadlines(): List<NewsHeadline>
}