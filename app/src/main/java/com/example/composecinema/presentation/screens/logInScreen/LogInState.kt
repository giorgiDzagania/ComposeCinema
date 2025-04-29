package com.example.composecinema.presentation.screens.logInScreen

data class LogInState(
    val email: String = "",
    val password: String = "",
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)
