package com.niko.kmm.newsappdemocomposemultiplatform.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.niko.kmm.newsappdemocomposemultiplatform.NewsAppTheme
import com.niko.kmm.newsappdemocomposemultiplatform.di.ViewModelsFac
import dev.icerock.moko.mvvm.compose.getViewModel


@Composable
fun App() {

    NewsAppTheme {
        val viewModel = getViewModel(
            key = "News_Home_screen",
            factory = ViewModelsFac.getNewsHomeViewModelFactory()
        )

        NewsAppHomeScreen(
            viewModel.state.collectAsState().value,
            viewModel::dispatch
        )
    }
}