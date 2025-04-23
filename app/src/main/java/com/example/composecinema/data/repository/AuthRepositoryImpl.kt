package com.example.composecinema.data.repository

import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepositoryImpl(
    auth: FirebaseAuth
) : AuthRepository {

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): OperationStatus<FirebaseUser> {
        TODO("Not yet implemented")
    }
}