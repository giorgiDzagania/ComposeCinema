package com.example.composecinema.domain.useCases.userDetailsUseCases

import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.FirebaseRepository

class GetUserNameUseCase(
    private val repository: FirebaseRepository
) {
    suspend operator fun invoke(): OperationStatus<String> {
        return repository.getUsername()
    }
}
