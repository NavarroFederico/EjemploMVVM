package com.example.modelviewviewmodel.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
/*
//utilizamos un StateFlow es propio de las corrutinas es propio de Kotlin
//Kotlin nos permite que sea multiplataforma
//Ventaja de stateFlow al momento de utlizar las corrutinas... Cuando estemos en el repositorio vamos a utilizar las SuspendFunctions
 */
class MainViewModel : ViewModel() {


    private var _count= MutableStateFlow<Int>(0)//la diferencia con el LiveData es que nos pide un valor inicial y por lo tanto no va necesitar de un bloque Init
    val count: StateFlow<Int> = _count








    override fun onCleared() {
        super.onCleared()
        Log.d("ActividadPrincipal", "On cleared...Se finaliza el ciclo de vida del viewModel")
    }
}