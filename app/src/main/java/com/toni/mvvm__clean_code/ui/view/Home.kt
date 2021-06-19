package com.toni.mvvm__clean_code.ui.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.toni.mvvm__clean_code.data.models.Article
import com.toni.mvvm__clean_code.databinding.ActivityHomeBinding
import com.toni.mvvm__clean_code.ui.viewModel.HomeViewModel


class Home : AppCompatActivity()  {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        viewModel.getArticles().observe(this, Observer<List<Article>>{ articles ->
            binding.tvWelcome.text = articles.toString()
        })






    }

}
