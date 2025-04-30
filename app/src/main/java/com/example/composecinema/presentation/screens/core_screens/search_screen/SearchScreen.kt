package com.example.composecinema.presentation.screens.core_screens.search_screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composecinema.presentation.navigation.NavDest

fun NavGraphBuilder.searchScreenDestination(

) = composable<NavDest.Search> {

    SearchScreen()

}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(

    ) { paddingValues ->

    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}