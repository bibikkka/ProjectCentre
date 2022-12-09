package com.example.projectcentre.data.repository

import com.example.projectcentre.data.remote.api.UserApi
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val userApi: UserApi
) {

}