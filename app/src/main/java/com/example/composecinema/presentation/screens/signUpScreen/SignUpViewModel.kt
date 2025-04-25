package com.example.composecinema.presentation.screens.signUpScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.useCases.AuthUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(SignUpState())
    val viewState = _viewState.asStateFlow()

    fun signUpUser(
        name: String,
        email: String,
        password: String,
    ) {
        viewModelScope.launch {
            _viewState.value = _viewState.value.copy(isLoading = true, error = null)
            when (val result = authUseCase(name, email, password)) {
                is OperationStatus.Success -> {
                    _viewState.value = _viewState.value.copy(
                        name = name,
                        email = email,
                        password = password,
                        isLoading = false,
                    )
                }

                is OperationStatus.Failure -> {
                    _viewState.value =
                        _viewState.value.copy(
                            isLoading = false,
                            error = result.exception.toString()
                        )
                }
            }
            _viewState.value = _viewState.value.copy(isLoading = false, error = null)
        }
    }
}