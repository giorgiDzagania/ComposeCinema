package com.example.composecinema.presentation.screens.welcome_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composecinema.R
import com.example.composecinema.presentation.navigation_graph.NavDest
import com.example.composecinema.presentation.ui.theme.BlueAccent
import com.example.composecinema.presentation.ui.theme.Dark
import com.example.composecinema.presentation.ui.theme.White

fun NavGraphBuilder.welcomeDestination(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) = composable<NavDest.Welcome> {
    WelcomeScreen(
        onSignUpClick = onSignUpClick,
        onLoginClick = onLoginClick
    )
}

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Dark)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(120.dp))
            Icon(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "Logo",
                tint = BlueAccent,
                modifier = Modifier.size(88.dp)
            )
            Text(
                text = "CINEMAX",
                color = White,
                fontSize = 34.sp,
                letterSpacing = 3.sp,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(top = 34.dp)
            )
            Button(
                onClick = { onSignUpClick.invoke() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueAccent,
                    contentColor = White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 12.dp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 43.dp, horizontal = 16.dp)
                    .height(56.dp)
            ) {
                Text(
                    text = "Sign up",
                )
            }
            Row {
                Text(
                    text = "I already have an account? ",
                    color = Color.Gray,
                    fontSize = 18.sp
                )
                Text(
                    text = "Login",
                    color = BlueAccent,
                    fontSize = 18.sp,
                    modifier = Modifier.clickable {
                        onLoginClick.invoke()
                    }
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 0.3.dp,
                    color = Color.Gray
                )
                Text(
                    text = "  or sign up with  ",
                    color = Color.Gray,
                    fontSize = 18.sp,
                    fontFamily = FontFamily.SansSerif
                )
                HorizontalDivider(
                    color = Color.Gray,
                    thickness = 0.3.dp,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp, vertical = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(69.dp) // match your vector size
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_google),
                        contentDescription = "Google",
                        tint = Color.Unspecified,
                    )
                }
                Spacer(modifier = Modifier.size(32.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(69.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_facebook),
                        contentDescription = "Facebook",
                        tint = Color.Unspecified,
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogInOrSignUpScreenPreview() {
    WelcomeScreen(
        onSignUpClick = {},
        onLoginClick = {}
    )
}
