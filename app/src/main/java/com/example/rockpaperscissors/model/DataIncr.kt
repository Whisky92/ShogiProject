package com.example.rockpaperscissors.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataIncr : ViewModel(){

    private var _counter: MutableLiveData<Int> = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    init {
        _counter.value = 0
    }

    fun incr() {
        _counter.value?.let { a ->
            _counter.value = a + 1
        }
    }
}
