package com.example.composecinema.presentation.screens.signUpScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(SignUpState())
    val viewState = _viewState.asStateFlow()


    fun signUp(name: String, email: String, password: String) = viewModelScope.launch {

        when (authUseCase(name, email, password)) {
            is OperationStatus.Success -> {

            }
        }

    }

    fun authInputs(
        name: String,
        email: String,
        password: String
    ) {
        _viewState.update {
            it.copy(
                name = name,
                email = email,
                password = password
            )
        }

    }

}