package com.toni.mvvm__clean_code.ui.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.toni.mvvm__clean_code.databinding.ActivityHomeBinding
import com.toni.mvvm__clean_code.ui.home.view.controller.HomeController


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val controller: HomeController = HomeController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


}
