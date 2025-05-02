package com.example.composecinema.presentation.screens.core_screens.profile_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.composecinema.presentation.bottom_navigation.BottomNavigationBar
import com.example.composecinema.presentation.navigation_graph.NavDest

fun NavGraphBuilder.profileScreenDestination(
    navController: NavHostController
) = composable<NavDest.Profile> {

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        ProfileScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }

}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            "Profile Screen"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
