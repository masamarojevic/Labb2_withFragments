package com.example.labb2_withfragments.Counter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow((CounterUiState()))
    val uiState: StateFlow<CounterUiState> = _uiState.asStateFlow()

    fun add() {

        _uiState.update {
                state -> state.copy(
            counterPoints = state.counterPoints + 1
        )
        }
    }
}
