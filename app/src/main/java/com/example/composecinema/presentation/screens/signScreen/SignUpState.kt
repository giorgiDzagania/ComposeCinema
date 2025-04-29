package com.example.composecinema.presentation.screens.signScreen

data class SignUpState(
    var name: String = "",
    val email: String = "",
    val password: String = "",
    val isSignedUp: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)
