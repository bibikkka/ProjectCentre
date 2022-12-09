package com.example.projectcentre.presentation.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
//    private val tasks: GetTasksDetailsUseCase
) : ViewModel() {

//    private val _state = MutableStateFlow(
//        MainDetailsState(
//            detailsTasksState = DetailsTasksState(isLoading = true, data = null),
//        )
//    )
//    val state = _state.asStateFlow()
//
//    fun getTasks(id: Int){
//        tasks.invoke(id).onEach { value ->
//            _state.tryEmit(
//                _state.value.copy(
//                    detailsTasksState = _state.value.detailsTasksState.copy(
//                        isLoading = false,
//                        data = value.data
//                    )
//                )
//            )
//        }.launchIn(viewModelScope)
//    }
}