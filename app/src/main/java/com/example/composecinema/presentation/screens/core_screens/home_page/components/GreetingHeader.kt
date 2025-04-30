package com.example.composecinema.presentation.screens.core_screens.home_page.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecinema.R

@Composable
fun GreetingHeader(
    userName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_facebook),
            contentDescription = "User Image"
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = modifier
        ) {
            Text(
                "Hello, $userName",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Let's find your favorite movie",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingHeaderPreview() {
    GreetingHeader("User")
}
