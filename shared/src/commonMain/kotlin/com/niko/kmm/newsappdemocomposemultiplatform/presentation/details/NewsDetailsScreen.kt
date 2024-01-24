package com.niko.kmm.newsappdemocomposemultiplatform.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import com.niko.kmm.newsappdemocomposemultiplatform.MyApplicationTheme
import com.niko.kmm.newsappdemocomposemultiplatform.di.ViewModelsFac
import com.seiko.imageloader.rememberImagePainter
import dev.icerock.moko.mvvm.compose.getViewModel

data class NewsDetailScreen(
    val newsHeadlineTitle: String
) : Screen {
    @Composable
    override fun Content() {
        MyApplicationTheme() {
            val viewModel = getViewModel(
                key = "News_Detail_Screen",
                factory = ViewModelsFac.getNewsDetailViewModelFactory()
            )

            ScreenContent(
                viewModel.state.collectAsState().value,
                viewModel::dispatch
            )

            LaunchedEffect(Unit) {
                viewModel.getDetailedData(newsHeadlineTitle)
            }

        }
    }

    private @Composable
    fun ScreenContent(
        state: NewsDetailViewState,
        dispatch: (HomeDetailScreenEvents) -> Unit,

        ) {
        Scaffold(
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.onBackground,
            topBar = {
                TopBar(state.newsHeadlineUi.source)
            }
        ) { padding ->

            Column(
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                val painter =
                    rememberImagePainter(state.newsHeadlineUi.urlToImage)
                Image(
                    painter, null,
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                )


                Text(
                    text = state.newsHeadlineUi.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                )

                Text(
                    modifier = Modifier.padding(
                        horizontal = 16.dp
                    ),
                    text = state.newsHeadlineUi.description,
                    fontSize = 16.sp,
                    minLines = 8
                )

                Text(
                    modifier = Modifier.padding(
                        horizontal = 16.dp
                    ),
                    text = state.newsHeadlineUi.content,
                    fontSize = 16.sp,
                    minLines = 8
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(source: String) {
    TopAppBar(
        title = {
            Text(
                text = "Source: $source", color = Color.Black
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
    )
}