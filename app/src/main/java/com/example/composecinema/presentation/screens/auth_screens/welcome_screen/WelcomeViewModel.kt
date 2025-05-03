package com.example.composecinema.presentation.screens.auth_screens.welcome_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WelcomeViewModel() : ViewModel() {

    private val _viewState = MutableStateFlow(WelcomeState())
    val viewState = _viewState.asStateFlow()

    private val _effect = MutableSharedFlow<WelcomeEffect>()
    val effect = _effect.asSharedFlow()

    fun onEvent(event: WelcomeEvent) {
        when (event) {
            WelcomeEvent.onLoginClick -> {
                viewModelScope.launch {
                    _effect.emit(WelcomeEffect.NavigateToLogin)
                }
            }

            WelcomeEvent.onSignUpClick -> {
                viewModelScope.launch {
                    _effect.emit(WelcomeEffect.NavigateToSignUp)
                }
            }
        }
    }

}
