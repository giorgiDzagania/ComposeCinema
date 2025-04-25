package com.example.composecinema.presentation.screens.signUpScreen

import android.util.Log.d
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

    fun updateFields(field: SignUpFields, value: String) {
        _viewState.update {
            when (field) {
                SignUpFields.NAME -> it.copy(name = value)
                SignUpFields.EMAIL -> it.copy(email = value)
                SignUpFields.PASSWORD -> it.copy(password = value)
            }
        }
    }

    fun signUpUser() {
        viewModelScope.launch {
            val name = _viewState.value.name
            val email = _viewState.value.email
            val password = _viewState.value.password

            val inputError = validateInputs(name, email, password)
            if (inputError != null) {
                _viewState.value = _viewState.value.copy(error = inputError)
                return@launch
            }

            _viewState.value = _viewState.value.copy(isLoading = true, error = null)

            when (val result = authUseCase(name, email, password)) {
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

            // _viewState.value = _viewState.value.copy(isLoading = false, error = null)
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
