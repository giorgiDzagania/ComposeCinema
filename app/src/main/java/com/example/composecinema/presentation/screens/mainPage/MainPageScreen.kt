package com.example.composecinema.presentation.screens.mainPage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composecinema.presentation.navigation.NavDest
import com.example.composecinema.presentation.screens.mainPage.components.GreetingHeader
import com.example.composecinema.presentation.screens.mainPage.components.SearchBar
import com.example.composecinema.presentation.screens.mainPage.components.UpcomingMovies
import com.example.composecinema.presentation.ui.theme.Dark
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.mainPageDestination(
    navigateOnSearchScreen: () -> Unit
) = composable<NavDest.Main> {

    val viewModel = koinViewModel<MainPageViewModel>()
    val viewState = viewModel.viewState.collectAsStateWithLifecycle().value

    LaunchedEffect(viewState.navigateToSearchScreen) {
        viewModel.onEvent(MainPageEvent.LoadUser)

        if (viewState.navigateToSearchScreen) {
            navigateOnSearchScreen()
            viewModel.onEvent(MainPageEvent.ResetNavigation)
        }
    }

    MainPageScreen(
        viewState = viewState,
        onEvent = { action -> viewModel.onEvent(action) }
    )

}


@Composable
fun MainPageScreen(
    viewState: MainPageState,
    onEvent: (MainPageEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Dark)
                .padding(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            if (viewState.loading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            viewState.errorMessage.let {
                Text(
                    text = it,
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            if (!viewState.loading) {
                viewState.userName?.let {
                    GreetingHeader(userName = it, modifier = modifier)
                }
                SearchBar(
                    modifier = modifier.padding(vertical = 16.dp),
                    onEvent = { onEvent(MainPageEvent.OnSearchClick) }
                )
                UpcomingMovies()
            }

        }
    }
}


@Composable
@Preview(showBackground = true)
fun MainPageScreenPreview() {
    MainPageScreen(
        viewState = MainPageState(),
        onEvent = {}
    )
}
