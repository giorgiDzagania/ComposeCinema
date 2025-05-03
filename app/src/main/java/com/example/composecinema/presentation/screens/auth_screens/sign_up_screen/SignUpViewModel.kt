package com.example.composecinema.presentation.screens.auth_screens.sign_up_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.use_cases.auth_use_case.SignUpUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(SignUpState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: SignUpEvent) {
        when (action) {
            is SignUpEvent.FullNameChanged -> {
                _viewState.update { it.copy(fullName = action.value, error = null) }
            }

            is SignUpEvent.EmailChanged -> {
                _viewState.update { it.copy(email = action.value, error = null) }
            }

            is SignUpEvent.PasswordChanged -> {
                _viewState.update { it.copy(password = action.value, error = null) }
            }

            SignUpEvent.OnBackClicked -> {
                _viewState.update { it.copy(isBackButtonClicked = true) }
            }

            SignUpEvent.OnSubmitBtnClicked -> {
                signUpUser()
            }
        }
    }

    private fun signUpUser() {
        viewModelScope.launch {
            val name = _viewState.value.fullName
            val email = _viewState.value.email
            val password = _viewState.value.password
            val inputError = validateInputs(name, email, password)
            if (inputError != null) {
                _viewState.value = _viewState.value.copy(error = inputError)
                return@launch
            }
            _viewState.value = _viewState.value.copy(isLoading = true, error = null)

            when (val result = signUpUseCase(name, email, password)) {
                is OperationStatus.Success -> {
                    _viewState.value = _viewState.value.copy(
                        isLoading = false,
                        isSignedUp = true
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
    }

    private fun validateInputs(
        name: String,
        email: String,
        password: String
    ): String? {
        return when {
            name.isBlank() -> "Name must not be blank"
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Invalid Email Format"
            password.length < 6 -> "Password must be at least 6 characters"
            else -> null
        }
    }

}
