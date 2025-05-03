package com.example.composecinema.presentation.screens.auth_screens.welcome_screen

sealed class WelcomeEffect {
    object NavigateToLogin : WelcomeEffect()
    object NavigateToSignUp : WelcomeEffect()
}
