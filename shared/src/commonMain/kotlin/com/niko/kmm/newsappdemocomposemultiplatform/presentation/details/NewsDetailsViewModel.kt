package com.niko.kmm.newsappdemocomposemultiplatform.presentation.details

import com.niko.kmm.newsappdemocomposemultiplatform.domain.usecase.GetNewsDetailsUseCaseImpl
import com.niko.kmm.newsappdemocomposemultiplatform.presentation.home.NewsHeadlineUI
import com.niko.kmm.newsappdemocomposemultiplatform.presentation.details.HomeDetailScreenEvents.BackButtonClicked
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsDetailsViewModel(
    private val getNewsDetailsUseCaseImpl: GetNewsDetailsUseCaseImpl
) : ViewModel() {


    private var _state = MutableStateFlow(
        NewsDetailViewState(
            NewsHeadlineUI(
                author = "",
                content = "",
                description = "",
                title = "",
                source = "",
                urlToImage = "",
                publishedAt = "",
                url = "",
            )
        )
    )
    val state = _state.asStateFlow()

    private val events = MutableSharedFlow<HomeDetailScreenEvents>()
    private val _events = events.asSharedFlow()


    suspend fun getDetailedData(title: String) {
        handleEvents()
        viewModelScope.launch(Dispatchers.IO) {

            val newsHeadline = getNewsDetailsUseCaseImpl(title)

            _state.update { newsDetailViewState ->

                newsDetailViewState.copy(
                    newsHeadlineUi = NewsHeadlineUI(
                        author = newsHeadline.author,
                        content = newsHeadline.content,
                        description = newsHeadline.description,
                        title = newsHeadline.title,
                        source = newsHeadline.source,
                        urlToImage = newsHeadline.urlToImage,
                        publishedAt = newsHeadline.publishedAt,
                        url = newsHeadline.url,
                    )
                )
            }
        }
    }

    private fun handleEvents() {
        events
            .filterIsInstance<HomeDetailScreenEvents>()
            .map { runCatching { handle(it) } }
            .map { it.exceptionOrNull() }
            .filterNotNull()
            .launchIn(viewModelScope)
    }

    private fun handle(homeDetailScreenEvents: HomeDetailScreenEvents) {
        when (homeDetailScreenEvents) {
            is BackButtonClicked -> {

            }
        }
    }

    fun dispatch(events: HomeDetailScreenEvents) {
        viewModelScope.launch {
           // _events.emit(events)
        }
    }
}