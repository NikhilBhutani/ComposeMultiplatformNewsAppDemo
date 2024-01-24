package com.niko.kmm.newsappdemocomposemultiplatform.domain.usecase

import com.niko.kmm.newsappdemocomposemultiplatform.domain.model.NewsHeadline
import com.niko.kmm.newsappdemocomposemultiplatform.domain.repository.GetNewsRepository

class GetNewsDetailsUseCaseImpl(
    private val newsRepository: GetNewsRepository
) {
    suspend operator fun invoke(title: String): NewsHeadline {
        return newsRepository.getDetailedNewsOfTitle(title)
    }
}