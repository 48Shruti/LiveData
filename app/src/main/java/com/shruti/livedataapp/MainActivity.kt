package com.shruti.livedataapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.shruti.livedataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding  : ActivityMainBinding
    lateinit var colorviewmodel:ColorViewModel
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        colorviewmodel = ViewModelProvider(this).get(ColorViewModel::class.java)
        binding.btnred.setOnClickListener {
            System.out.println("on red clicked ")
            colorviewmodel.color.value = 1
        }
        binding.btnblue.setOnClickListener {
            colorviewmodel.color.value = 2
        }
        binding.btngreen.setOnClickListener {
            colorviewmodel.color.value = 3
        }
        binding.btnplus.setOnClickListener {
            number = number + 1
            binding.number.setText(number.toString())
            colorviewmodel.number.value = number
        }
        binding.btnminus.setOnClickListener {
            number = number - 1
            binding.number.setText(number.toString())
            colorviewmodel.number.value= number
        }
        colorviewmodel.reset.observe(this){
            binding.number.setText(it.toString())
        }
    }
}