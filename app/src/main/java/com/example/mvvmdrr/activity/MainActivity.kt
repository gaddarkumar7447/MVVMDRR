package com.example.mvvmdrr.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmdrr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        setContentView(binding.root)
    }
}