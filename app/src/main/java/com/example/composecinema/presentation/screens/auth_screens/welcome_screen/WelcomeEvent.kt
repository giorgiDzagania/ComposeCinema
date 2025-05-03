package com.example.composecinema.presentation.screens.auth_screens.welcome_screen

sealed class WelcomeEvent {
    object onLoginClick : WelcomeEvent()
    object onSignUpClick : WelcomeEvent()
}
