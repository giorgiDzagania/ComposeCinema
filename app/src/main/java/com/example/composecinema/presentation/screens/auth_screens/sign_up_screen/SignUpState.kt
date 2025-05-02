package com.example.composecinema.presentation.screens.auth_screens.sign_up_screen

data class SignUpState(
    val fullName: String = "",
    val email: String = "",
    val password: String = "",
    val isSignedUp: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
)
