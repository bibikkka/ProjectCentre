package com.example.projectcentre.data.repository

import com.example.projectcentre.data.remote.api.UserApi
import com.example.projectcentre.domain.model.response.UserResponse
import retrofit2.Response
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val userApi: UserApi
) {
    suspend fun getUsersByRole(role: String): Response<UserResponse> {
        return userApi.getUsersByRole(role)
    }

}