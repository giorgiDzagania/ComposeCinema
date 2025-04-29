package com.example.composecinema.presentation.screens.logInScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.useCases.auth_usecase.SignInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(SignInState())
    val viewState = _viewState.asStateFlow()


    fun signIn() = viewModelScope.launch {
        val email = _viewState.value.email
        val password = _viewState.value.password

        val inputError = validateInputs(email, password)
        if (inputError != null) {
            _viewState.value = _viewState.value.copy(error = inputError)
            return@launch
        }

        _viewState.value = _viewState.value.copy(isLoading = true, error = null)
        when (val result = signInUseCase(email, password)) {
            is OperationStatus.Success -> {
                _viewState.value = _viewState.value.copy(
                    isLoading = false,
                    isSignedIn = true
                )
            }

            is OperationStatus.Failure -> {
                _viewState.value = _viewState.value.copy(
                    isLoading = false,
                    error = result.exception.message ?: "Unknown error"
                )
            }
        }
    }

    fun updateFields(field: SignInFields, value: String) {
        _viewState.update {
            when (field) {
                SignInFields.EMAIL -> it.copy(email = value)
                SignInFields.PASSWORD -> it.copy(password = value)
            }
        }
    }

    fun togglePasswordVisibility() {
        _viewState.update { currentState ->
            currentState.copy(isPasswordVisible = !currentState.isPasswordVisible)
        }
    }

    private fun validateInputs(
        email: String,
        password: String
    ): String? {
        return when {
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid Email Format"
            password.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }
    }
}