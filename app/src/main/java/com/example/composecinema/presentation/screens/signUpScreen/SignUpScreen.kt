package com.example.composecinema.presentation.screens.signUpScreen

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composecinema.presentation.ui.theme.BlueAccent
import com.example.composecinema.presentation.ui.theme.Dark
import com.example.composecinema.presentation.ui.theme.Green
import com.example.composecinema.presentation.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    onBackPress: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    viewModel: SignUpViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val viewState by viewModel.viewState.collectAsState()

    Scaffold(
        containerColor = Dark,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Sign Up") },
                navigationIcon = {
                    IconButton(onClick = {onBackPress.invoke()}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Dark,
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                )
            )
        }
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
                .background(Dark)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier.padding(28.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Let's get started",
                        color = Color.White,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "The latest movies and series are here",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                }
                Column {
                    OutlinedTextField(
                        value = viewState.name,
                        onValueChange = {
                            viewModel.authInputs(name = it, viewState.email, viewState.password)
                        },
                        label = {
                            Text(
                                text = "Full Name",
                                color = Color.White.copy(alpha = 0.7f)
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
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
                        value = viewState.email,
                        onValueChange = {
                            viewModel.authInputs(viewState.name, email = it, viewState.password)
                        },
                        label = {
                            Text(
                                text = "Email Address",
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
                        onValueChange = {
                            viewModel.authInputs(viewState.name, viewState.email, password = it)
                        },
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
                }
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
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
