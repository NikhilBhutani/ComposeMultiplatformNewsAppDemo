package com.niko.kmm.newsappdemocomposemultiplatform.data.database

import com.niko.kmm.newsappdemocomposemultiplatform.data.models.Article

interface NewsLocalDataSource {
  fun addNews(articles: List<Article>)
  fun clearDatabase()
  fun selectNewsInfo(title: String): Article

}