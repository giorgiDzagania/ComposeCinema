package com.example.composecinema.domain.useCases.authenticationUseCases

import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser

class LogInUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): OperationStatus<FirebaseUser> {
        return repository.loginIn(email = email, password = password)
    }
}
