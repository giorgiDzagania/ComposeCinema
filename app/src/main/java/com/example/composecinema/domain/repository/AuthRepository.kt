package com.example.composecinema.domain.repository

import com.example.composecinema.core.OperationStatus
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun signUp(name: String, email: String, password: String): OperationStatus<FirebaseUser>
    suspend fun loginIn(email: String, password: String): OperationStatus<FirebaseUser>
    suspend fun getUsername(): OperationStatus<String>
}