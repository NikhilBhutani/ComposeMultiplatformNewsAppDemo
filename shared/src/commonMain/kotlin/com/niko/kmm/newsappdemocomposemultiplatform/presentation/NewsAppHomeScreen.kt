package com.niko.kmm.newsappdemocomposemultiplatform.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

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
        when {
            state.isError -> {
                ShowErrorSnackBar(state.errorString)
            }

            else -> {
                LazyColumn(modifier = Modifier.padding(padding)) {

                    items(state.newsHeadlinesUi.size) {
                        NewsHeadLineItem(state.newsHeadlinesUi[it])
                    }

                }
            }
        }


    }
}

@Composable
fun ShowErrorSnackBar(errorString: String) {
    val snackbarHostState = remember { SnackbarHostState() }
    val snackBarHost = SnackbarHost(snackbarHostState)
    val coroutineScope = rememberCoroutineScope()
    coroutineScope.launch {
        snackbarHostState.showSnackbar(message = errorString, duration = SnackbarDuration.Long)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "KMM News App", color = Color.Black
            )
        },
        colors = topAppBarColors(containerColor = Color.Transparent),
    )
}