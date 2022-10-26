package com.example.modelviewviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.modelviewviewmodel.databinding.ActivityMainBinding
import com.example.modelviewviewmodel.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    val tag = "ActividadPrincipal"
    private lateinit var binding: ActivityMainBinding

    private var count: Int = 0

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(tag, "OnCreate de la actividad")

        btn_plus.setOnClickListener { viewModel.incrementarValor() }
        btn_minus.setOnClickListener { viewModel.decrementarValor() }


        //collect es una funcion suspendible por eso vamos a ejecutarla dentro de una corrutina
        lifecycleScope.launchWhenStarted {
            viewModel.count.collect { value ->//tiene que colectar
                binding.tvCount.text = value.toString()
                Log.d("actividad","estoy${value}")
            }
        }
            lifecycleScope.launchWhenStarted {
                viewModel.event.collect{
                    if (it){
                        Toast.makeText(this@MainActivity, "numero Invalidado", Toast.LENGTH_SHORT)
                            .show()
                    }
            }
    }


    btn_finish.setOnClickListener{
        finish()
        Log.d(tag, "onFinish de la actividad")
    }

}

override fun onDestroy() {
    super.onDestroy()
    Log.d(tag, "On destroy de la actividad")

}

}