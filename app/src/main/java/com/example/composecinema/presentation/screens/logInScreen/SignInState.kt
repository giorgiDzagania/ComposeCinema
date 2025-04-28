package com.example.composecinema.presentation.screens.logInScreen

data class SignInState(
    val email: String = "",
    val password: String = "",
    var isPasswordVisible: Boolean = false,
    val isSignedIn: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)