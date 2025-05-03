package com.example.composecinema.presentation.screens.core_screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.composecinema.presentation.bottom_navigation.BottomNavigationBar
import com.example.composecinema.presentation.navigation_graph.NavDest
import com.example.composecinema.presentation.screens.core_screens.home_screen.components.GreetingHeader
import com.example.composecinema.presentation.screens.core_screens.home_screen.components.SearchBar
import com.example.composecinema.presentation.screens.core_screens.home_screen.components.UpcomingMovies
import com.example.composecinema.presentation.ui.theme.Dark
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homePageDestination(
    modifier: Modifier = Modifier,
    navigateOnSearchScreen: () -> Unit,
    navController: NavHostController
) = composable<NavDest.Home> {
    val viewModel = koinViewModel<HomeViewModel>()
    val viewState = viewModel.viewState.collectAsStateWithLifecycle().value

    LaunchedEffect(viewState.navigateToSearchScreen) {
        viewModel.onEvent(HomeEvent.LoadUser)

        if (viewState.navigateToSearchScreen) {
            navigateOnSearchScreen()
            viewModel.onEvent(HomeEvent.ResetNavigation)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Dark)
                .padding(paddingValues)
                .padding(12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            HomeScreen(
                viewState = viewState,
                onEvent = { action -> viewModel.onEvent(action) }
            )
        }
    }

}

@Composable
fun HomeScreen(
    viewState: HomeState,
    onEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        if (viewState.loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        if (viewState.errorMessage.isNotEmpty()) {
            Text(
                text = viewState.errorMessage,
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        if (!viewState.loading) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.Start
            ) {
                viewState.userName?.let {
                    GreetingHeader(userName = it)
                }
                SearchBar(
                    modifier = Modifier.padding(vertical = 16.dp),
                    onEvent = { onEvent(HomeEvent.OnSearchClick) }
                )
                UpcomingMovies()
            }
        }
    }
}




@Composable
@Preview(showBackground = true)
fun MainPageScreenPreview() {
    HomeScreen(
        viewState = HomeState(),
        onEvent = {}
    )
}
