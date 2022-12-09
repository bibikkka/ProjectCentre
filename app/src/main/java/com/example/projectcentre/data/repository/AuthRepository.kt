package com.example.projectcentre.data.repository

import com.example.projectcentre.data.remote.api.AuthApi
import com.example.projectcentre.domain.model.response.UserResponse
import com.example.projectcentre.domain.model.user.UserSignIn
import com.example.projectcentre.domain.model.user.UserSignUp
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApi: AuthApi
) {

    suspend fun signIn(user: UserSignIn): Response<UserResponse> {
        return authApi.signIn(user)
    }

    suspend fun signUp(user: UserSignUp): Response<UserResponse> {
        return authApi.signUp(user)
    }


}