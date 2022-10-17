package com.example.modelviewviewmodel.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/*
//utilizamos un StateFlow es propio de las corrutinas es propio de Kotlin
//Kotlin nos permite que sea multiplataforma
//Ventaja de stateFlow al momento de utlizar las corrutinas... Cuando estemos en el repositorio vamos a utilizar las SuspendFunctions
 */
class MainViewModel : ViewModel() {


    private var _time = MutableStateFlow<Int>(0)//la diferencia con el LiveData es que nos pide un valor inicial y por lo tanto no va necesitar de un bloque Init
    val time: StateFlow<Int> = _time

    init {
        startTime()
    }

    private fun startTime() {
        (60 downTo 0).asFlow().onEach { value ->
            _time.value = value
            delay(1000)
        }.launchIn(viewModelScope) //le indico en que Scope se va a correr
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("ActividadPrincipal", "On cleared...Se finaliza el ciclo de vida del viewModel")
    }
}