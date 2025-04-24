package com.example.composecinema.presentation.screens.signUpScreen

data class SignUpState(
    var name: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
)
