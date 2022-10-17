package com.example.modelviewviewmodel.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/*
//utilizamos un StateFlow es propio de las corrutinas es propio de Kotlin
//Kotlin nos permite que sea multiplataforma
//Ventaja de stateFlow al momento de utlizar las corrutinas... Cuando estemos en el repositorio vamos a utilizar las SuspendFunctions
 */
class MainViewModel : ViewModel() {


    private var _count =
        MutableStateFlow<Int>(0)//la diferencia con el LiveData es que nos pide un valor inicial y por lo tanto no va necesitar de un bloque Init
    val count: StateFlow<Int> = _count

    private var _event = MutableSharedFlow<Boolean>()
    val event = _event.asSharedFlow()


    fun incrementarValor() {
        _count.value = _count.value.plus(1)
    }

    fun decrementarValor() {
        if (_count.value > 0) {
            _count.value = _count.value.minus(1)
        } else {
            viewModelScope.launch {
                _event.emit(true)
            }
        }

    }


    override fun onCleared() {
        super.onCleared()
        Log.d("ActividadPrincipal", "On cleared...Se finaliza el ciclo de vida del viewModel")
    }
}