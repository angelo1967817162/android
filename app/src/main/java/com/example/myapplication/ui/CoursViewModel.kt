package com.example.myapplication.ui


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.CoursUiState

import com.example.myapplication.service.CoursApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CoursViewModel : ViewModel() {
    private val _coursUi = MutableStateFlow<List<CoursUiState>>(emptyList())
    val coursUi: StateFlow<List<CoursUiState>> = _coursUi
    init {
        getCoursNames()
    }
    fun getCoursNames() {
        viewModelScope.launch {
            val response = CoursApi.retrofitService.getCoursList()
            _coursUi.value = response.results.map { cours ->
                CoursUiState( name = cours.username)
            }
        }
    }
}
