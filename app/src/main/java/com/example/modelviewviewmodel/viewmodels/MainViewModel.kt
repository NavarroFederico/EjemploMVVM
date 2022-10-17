package com.example.modelviewviewmodel.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {


    override fun onCleared() {
        super.onCleared()
        Log.d("ActividadPrincipal", "On cleared...Se finaliza el ciclo de vida del viewModel")
    }
}