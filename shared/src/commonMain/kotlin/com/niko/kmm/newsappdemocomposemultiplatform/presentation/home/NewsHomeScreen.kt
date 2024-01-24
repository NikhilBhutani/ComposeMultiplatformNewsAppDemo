package com.niko.kmm.newsappdemocomposemultiplatform.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import com.niko.kmm.newsappdemocomposemultiplatform.MyApplicationTheme

data class NewsHomeScreen(val viewModel: NewsHomeViewModel) : Screen {
    @Composable
    override fun Content() {
        MyApplicationTheme {

            NewsAppHomeScreen(
                viewModel.state.collectAsState().value,
                viewModel::dispatch
            )
            LaunchedEffect(Unit) {
                viewModel.getNews()
            }
        }
    }
}
