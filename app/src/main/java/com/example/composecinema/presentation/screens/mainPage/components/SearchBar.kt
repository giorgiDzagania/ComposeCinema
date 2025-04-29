package com.example.composecinema.presentation.screens.mainPage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecinema.presentation.screens.mainPage.MainPageEvent

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onEvent: (MainPageEvent) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.DarkGray.copy(alpha = 0.3f),
                shape = MaterialTheme.shapes.small
            )
            .clickable { onEvent(MainPageEvent.OnSearchClick) }
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Search for a movie...",
            color = Color.LightGray,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    SearchBar(
        onEvent = {}
    )
}