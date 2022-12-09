package com.example.projectcentre.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectcentre.domain.useCase.details.GetTasksDetailsUseCase
import com.example.projectcentre.presentation.detail.state.DetailsTasksState
import com.example.projectcentre.presentation.detail.state.MainDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val tasks: GetTasksDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(
        MainDetailsState(
            detailsTasksState = DetailsTasksState(isLoading = true, data = null),
        )
    )
    val state = _state.asStateFlow()

    fun getTasks(id: Int){
        tasks.invoke(id).onEach { value ->
            _state.tryEmit(
                _state.value.copy(
                    detailsTasksState = _state.value.detailsTasksState.copy(
                        isLoading = false,
                        data = value.data
                    )
                )
            )
        }.launchIn(viewModelScope)
    }
}