package com.example.train

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val countDownFLow = flow<Int> {
        val startValue = 10
        var currentValue = startValue
        emit(startValue)
        while (currentValue > 0){
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    init {
        collectFlow()
    }

    private fun collectFlow (){
        viewModelScope.launch {
            countDownFLow.collectLatest{
                delay(2000L)
                Log.e("KanExe", "collectFlow: $it")
            }
        }
    }

}