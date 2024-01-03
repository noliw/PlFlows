package com.example.plflows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val countDownFlow = flow<Int> {
        val startingValue = 10
        var currentValue = startingValue
        emit(startingValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    init {
        collectFlow()
    }

    fun increment() {
        _stateFlow.value += 1
    }

    private fun collectFlow() {
        viewModelScope.launch {
            countDownFlow
                // filters out elements matching a specific condition
                .filter { time ->
                    time % 2 == 0
                }
                // changes each element
                .map {
                    it * it
                }
                .onEach { time ->
                    println(time)
                }
                // counts the values that match a specific condition
                .count {
                    it % 2 == 0

                }
                /*.collect { time ->
                println(
                    "The current time is $time"
                )*/

        }
    }
}