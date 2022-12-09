package com.example.projectcentre.presentation.detail.state

import com.example.projectcentre.domain.model.tasks.Tasks

data class DetailsTasksState(
    val data: List<Tasks>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)