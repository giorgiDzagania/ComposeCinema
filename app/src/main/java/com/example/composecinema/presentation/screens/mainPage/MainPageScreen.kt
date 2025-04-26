package com.example.composecinema.presentation.screens.mainPage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composecinema.presentation.navigation.NavDest


fun NavGraphBuilder.mainPageDestination(

) = composable<NavDest.Main> {
    MainPageScreen()
}


@Composable
fun MainPageScreen(
    modifier: Modifier = Modifier
) {
    Scaffold { valuePadding ->
        Text(
            "Main Page",
            modifier = Modifier.padding(valuePadding)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MainPageScreenPreview() {
    MainPageScreen()
}