package com.example.composecinema.presentation.screens.mainPage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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