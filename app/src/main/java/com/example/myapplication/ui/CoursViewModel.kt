package com.example.myapplication.ui


import androidx.lifecycle.ViewModel
import com.example.myapplication.CoursUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class CoursViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(CoursUiState(
        string = "karaté",
        string1 = "cobra kai never dies",
        d = 24.2
    )
    )
    val uiState: StateFlow<CoursUiState> = _uiState.asStateFlow()


    }
