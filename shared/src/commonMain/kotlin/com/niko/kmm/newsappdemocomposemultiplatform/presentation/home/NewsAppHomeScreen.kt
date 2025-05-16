package com.niko.kmm.newsappdemocomposemultiplatform.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.niko.kmm.newsappdemocomposemultiplatform.presentation.details.NewsDetailScreen

@Composable
fun NewsAppHomeScreen(
    state: NewsHeadlineViewState,
    dispatch: (HomeScreenEvents) -> Unit
) {
    Scaffold(
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.onBackground,
        topBar = { TopBar() }
    ) { padding ->
        val screenNavigator = LocalNavigator.currentOrThrow
        val baseModifier = remember { padding }


        LazyColumn(modifier = Modifier.padding(padding)) {
            val newsHeadlineUIList = state.newsHeadlinesUi
            items(
                count = newsHeadlineUIList.size, key = { newsHeadlineUIList[0].title }) {
                NewsHeadLineItem(
                    newsHeadLine = newsHeadlineUIList[it],
                    onItemClick = { newsHeadlineUI ->
                        screenNavigator.push(NewsDetailScreen(newsHeadlineUI.title))
                    }
                )
            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "KMM News App", color = Color.Black
            )
        },
        colors = topAppBarColors(containerColor = Color.Transparent),
    )
}