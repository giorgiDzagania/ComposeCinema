<<<<<<<< HEAD:app/src/main/java/com/example/composecinema/domain/useCases/authenticationUseCases/AuthUseCase.kt
package com.example.composecinema.domain.useCases.authenticationUseCases
========
package com.example.composecinema.domain.useCases.auth_usecase
>>>>>>>> 01e0838f3af1cc8e54dcbf378e4425b596a37318:app/src/main/java/com/example/composecinema/domain/useCases/auth_usecase/SignUseCase.kt

import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseUser

class SignUseCase(
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