package com.example.modelviewviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.modelviewviewmodel.databinding.ActivityMainBinding
import com.example.modelviewviewmodel.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var count:Int = 0

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        }
        viewModel
    }


}