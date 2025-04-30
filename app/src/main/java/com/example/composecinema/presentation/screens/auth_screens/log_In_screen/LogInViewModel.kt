package com.example.composecinema.presentation.screens.auth_screens.log_In_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.use_cases.auth_use_case.LogInUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LogInViewModel(
    private val logInUseCase: LogInUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(LogInState())
    val viewState = _viewState.asStateFlow()


    fun onAction(action: LogInEvent) {
        when (action) {
            is LogInEvent.EmailChanged -> {
                _viewState.update { it.copy(email = action.value, error = null) }
            }

            is LogInEvent.PasswordChanged -> {
                _viewState.update { it.copy(password = action.value, error = null) }
            }

            is LogInEvent.SubmitLogin -> {
                logInUser()
            }

            is LogInEvent.OnBackClicked -> {
                _viewState.value = _viewState.value.copy(isLoggedIn = false)
            }
        }
    }

    private fun logInUser() {
        viewModelScope.launch {
            val email = _viewState.value.email
            val password = _viewState.value.password
            val inputError = validateInputs(email, password)
            if (inputError != null) {
                _viewState.value = _viewState.value.copy(error = inputError)
                return@launch
            }

            _viewState.value = _viewState.value.copy(isLoading = true, error = null)
            when (val status = logInUseCase(email, password)) {
                is OperationStatus.Success -> {
                    _viewState.value = _viewState.value.copy(
                        isLoading = false,
                        isLoggedIn = true
                    )
                }

                is OperationStatus.Failure -> {
                    _viewState.value = _viewState.value.copy(
                        isLoading = false,
                        error = status.exception.message ?: "Unknown error"
                    )
                }
            }
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
