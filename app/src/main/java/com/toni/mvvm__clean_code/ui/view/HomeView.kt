package com.toni.mvvm__clean_code.ui.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.ActivityHomeBinding
import com.toni.mvvm__clean_code.ui.view.home_controller.HomeController
import com.toni.mvvm__clean_code.ui.viewModel.HomeViewModel
import java.io.InputStream
import java.net.URL
import java.net.URLConnection


class HomeView : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val controller: HomeController = HomeController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


}
