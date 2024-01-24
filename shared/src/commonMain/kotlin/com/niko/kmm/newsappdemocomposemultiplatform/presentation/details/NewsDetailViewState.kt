package com.niko.kmm.newsappdemocomposemultiplatform.presentation.details

import androidx.compose.runtime.Immutable
import com.niko.kmm.newsappdemocomposemultiplatform.presentation.home.NewsHeadlineUI

@Immutable
data class NewsDetailViewState(
    val newsHeadlineUi: NewsHeadlineUI
)
