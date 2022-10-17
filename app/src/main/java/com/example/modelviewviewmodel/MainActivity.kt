package com.example.modelviewviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.modelviewviewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var TAG="ActividadPrincipal"
    private lateinit var binding: ActivityMainBinding

    private var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"On create...")
        btn_plus.setOnClickListener{
            count++
            tv_count.text = count.toString()
        }
        btn_minus.setOnClickListener{
            count--
            tv_count.text = count.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"On Destroy...")
    }


}