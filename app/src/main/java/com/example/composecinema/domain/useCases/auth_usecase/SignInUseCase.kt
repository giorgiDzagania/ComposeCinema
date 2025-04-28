package com.example.composecinema.domain.useCases.auth_usecase

import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser

class SignInUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String, password: String
    ): OperationStatus<FirebaseUser> {
        return authRepository.signIn(email, password)
    }
}