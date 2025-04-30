package com.example.composecinema.domain.use_cases.auth_use_case

import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.AuthRepository

class GetUserNameUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(): OperationStatus<String> {
        return repository.getUsername()
    }
}
