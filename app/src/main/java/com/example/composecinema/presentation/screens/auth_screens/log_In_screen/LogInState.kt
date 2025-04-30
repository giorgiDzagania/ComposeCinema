package com.example.composecinema.presentation.screens.auth_screens.log_In_screen

data class LogInState(
    val email: String = "",
    val password: String = "",
    val isLoggedIn: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)
