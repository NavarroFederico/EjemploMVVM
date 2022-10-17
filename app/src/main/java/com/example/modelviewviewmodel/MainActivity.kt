package com.example.modelviewviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.modelviewviewmodel.databinding.ActivityMainBinding
import com.example.modelviewviewmodel.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val tag = "ActividadPrincipal"
    private lateinit var binding: ActivityMainBinding

    private var count:Int = 0

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(tag,"OnCreate de la actividad")
        btn_plus.setOnClickListener{
            count++
            tv_count.text = count.toString()
        }
        btn_minus.setOnClickListener{
            count--
            tv_count.text = count.toString()
        }
        btn_finish.setOnClickListener{
            finish()
            Log.d(tag,"onFinish de la actividad")
        }
        viewModel
    }


}