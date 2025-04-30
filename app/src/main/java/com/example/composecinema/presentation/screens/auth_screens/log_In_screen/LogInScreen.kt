package com.example.composecinema.presentation.screens.auth_screens.log_In_screen

import android.util.Log.d
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.composecinema.presentation.navigation.NavDest
import com.example.composecinema.presentation.ui.theme.BlueAccent
import com.example.composecinema.presentation.ui.theme.Dark
import com.example.composecinema.presentation.ui.theme.Green
import com.example.composecinema.presentation.ui.theme.White
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.loginDestination(
    onBackClick: () -> Unit,
    onLogInSuccess: () -> Unit
) = composable<NavDest.Login> {

    val viewModel = koinViewModel<LogInViewModel>()
    val viewState = viewModel.viewState.collectAsState().value


    LaunchedEffect(viewState.isLoggedIn) {
        if (viewState.isLoggedIn) {
            onLogInSuccess()
        }
    }

    LogInScreen(
        viewState = viewState,
        onAction = { action ->
            if (action is LogInEvent.OnBackClicked) {
                onBackClick()
            } else {
                viewModel.onAction(action)
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInScreen(
    viewState: LogInState,
    onAction: (LogInEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    Scaffold(
        containerColor = Dark,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Login",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        letterSpacing = 2.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onAction(LogInEvent.OnBackClicked) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Transparent,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Dark)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Welcome back! Please enter\n your details",
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                OutlinedTextField(
                    value = viewState.email,
                    onValueChange = { onAction(LogInEvent.EmailChanged(it)) },
                    label = {
                        Text(
                            text = "Enter email",
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = BlueAccent,
                        unfocusedBorderColor = Gray,
                        cursorColor = BlueAccent,
                        focusedTextColor = White,
                        unfocusedTextColor = Green,
                    )
                )

                OutlinedTextField(
                    value = viewState.password,
                    onValueChange = { onAction(LogInEvent.PasswordChanged(it)) },
                    label = {
                        Text(
                            text = "Password",
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
//                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//                    trailingIcon = {
//                        Text(
//                            text = if (isPasswordVisible) "👁️" else "🔒",
//                            color = Color.Cyan,
//                            fontSize = 18.sp,
//                            modifier = Modifier
//                                .clickable { isPasswordVisible = !isPasswordVisible }
//                                .padding(4.dp)
//                        )
//                    },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(vertical = 8.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF64B5F6), // Light blue
                        unfocusedBorderColor = Color.Gray,
                        cursorColor = Color(0xFF64B5F6),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.Green
                    )
                )
                Button(
                    onClick = { onAction(LogInEvent.SubmitLogin) },
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
                        text = "Login"
                    )
                }

                if (viewState.isLoading) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CircularProgressIndicator(
                            color = BlueAccent,
                        )
                    }
                }

                viewState.error?.let { error ->
                    d("MyLog", "Error from viewState: $error")
                    Text(
                        text = error,
                        color = Color.Red,
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun LogInScreenPreview() {
    LogInScreen(
        viewState = LogInState(),
        onAction = {}
    )
}
