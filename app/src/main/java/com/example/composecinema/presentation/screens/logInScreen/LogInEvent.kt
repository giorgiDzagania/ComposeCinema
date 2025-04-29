package com.example.composecinema.presentation.screens.logInScreen

sealed class LogInEvent {
    data class EmailChanged(val value: String) : LogInEvent()
    data class PasswordChanged(val value: String) : LogInEvent()
    object SubmitLogin : LogInEvent()
    object OnBackClicked : LogInEvent()
}
