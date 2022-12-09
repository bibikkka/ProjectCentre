package com.example.projectcentre.presentation.signIn.state

import com.example.projectcentre.domain.model.user.User

data class UserSignInState(
    val data: List<User>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)