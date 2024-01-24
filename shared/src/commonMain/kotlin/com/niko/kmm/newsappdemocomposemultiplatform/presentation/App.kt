package com.niko.kmm.newsappdemocomposemultiplatform.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.niko.kmm.newsappdemocomposemultiplatform.MyApplicationTheme
import com.niko.kmm.newsappdemocomposemultiplatform.di.ViewModelsFac
import com.niko.kmm.newsappdemocomposemultiplatform.presentation.home.NewsAppHomeScreen
import com.niko.kmm.newsappdemocomposemultiplatform.presentation.home.NewsHomeScreen
import dev.icerock.moko.mvvm.compose.getViewModel


@Composable
fun App() {

    val viewModel = getViewModel(
        key = "News_Home_screen",
        factory = ViewModelsFac.getNewsHomeViewModelFactory()
    )

    Navigator(NewsHomeScreen(viewModel)) {
        SlideTransition(it)
    }
}