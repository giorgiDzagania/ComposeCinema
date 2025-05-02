package com.example.composecinema.presentation.screens.auth_screens.sign_up_screen

sealed class SignUpEvent {
    data class FullNameChanged(val value: String): SignUpEvent()
    data class EmailChanged(val value: String) : SignUpEvent()
    data class PasswordChanged(val value: String) : SignUpEvent()
    object OnBackClicked : SignUpEvent()
    object OnSubmitBtnClicked: SignUpEvent()
}
