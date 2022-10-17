package com.example.modelviewviewmodel.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    init{
        _count.value =0
    }



    fun incrementarValor() {
        _count.value = _count.value?.plus(1)
    }

    fun decrementarValor() {
        _count.value = _count.value?.minus(1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("ActividadPrincipal", "On cleared...Se finaliza el ciclo de vida del viewModel")
    }
}