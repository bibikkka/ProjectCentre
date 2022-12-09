package com.example.projectcentre.presentation.signIn

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
//    private val signIn: SignInUseCase
) : ViewModel() {

//    private val _state = MutableStateFlow(UserSignInState(isLoading = true, data = null))
//    val state = _state.asStateFlow()

    fun signIn(email: String, password: String) {
//        signIn.invoke(email = email, password = password).onEach { value ->
//            _state.tryEmit(
//                _state.value.copy(
//                    isLoading = false,
//                    data = value.data
//                )
//            )
//        }.launchIn(viewModelScope)
    }
}