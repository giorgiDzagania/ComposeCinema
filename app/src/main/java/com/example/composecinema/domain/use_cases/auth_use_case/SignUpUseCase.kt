package com.example.composecinema.domain.use_cases.auth_use_case

import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser

class SignUpUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): OperationStatus<FirebaseUser> {
        return authRepository.signUp(name, email, password)
    }
}