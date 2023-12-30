package com.niko.kmm.newsappdemocomposemultiplatform.domain.usecase

import com.niko.kmm.newsappdemocomposemultiplatform.domain.model.NewsHeadline
import com.niko.kmm.newsappdemocomposemultiplatform.domain.repository.GetNewsRepository

class GetNewsUseCaseImpl(
    private val getNewsRepository: GetNewsRepository
) {

    suspend operator fun invoke(): List<NewsHeadline> {
        return getNewsRepository.getHeadlines()
    }
}