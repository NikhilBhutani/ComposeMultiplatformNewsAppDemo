package com.niko.kmm.newsappdemocomposemultiplatform.presentation

import com.niko.kmm.newsappdemocomposemultiplatform.domain.usecase.GetNewsUseCaseImpl
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsHomeViewModel(
    private val newsHeadUseCaseImpl: GetNewsUseCaseImpl,
) : ViewModel() {

    private var _state = MutableStateFlow(NewsHeadlineViewState())
    val state = _state.asStateFlow()

    private var _events = MutableSharedFlow<HomeScreenEvents>()

    init {
        handleEvents()
        viewModelScope.launch(Dispatchers.IO) {

            runCatching {
                newsHeadUseCaseImpl.invoke()
                    .filter { it.author.isNotEmpty() }
                    .map {
                        NewsHeadlineUI(
                            author = it.author,
                            content = it.content,
                            description = it.description,
                            title = it.title,
                            source = "",
                            urlToImage = it.urlToImage,
                            publishedAt = "",
                            url = "",
                        )
                    }
            }.onSuccess {
                _state.update { newsHeadlineViewState ->
                    newsHeadlineViewState.copy(newsHeadlinesUi = it)
                }
            }.onFailure {
                _state.update {
                    newsHeadlineViewState ->
                    newsHeadlineViewState.copy(
                        isError = true,
                        errorString = it.message ?: "Generic error, please debug"
                    )
                }
            }

        }
    }


    fun dispatch(events: HomeScreenEvents) {
        viewModelScope.launch {
            _events.emit(events)
        }
    }

    private fun handleEvents() {

    }
}