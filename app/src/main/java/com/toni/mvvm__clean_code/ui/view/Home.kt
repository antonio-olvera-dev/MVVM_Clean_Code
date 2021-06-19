package com.toni.mvvm__clean_code.ui.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.ActivityHomeBinding
import com.toni.mvvm__clean_code.ui.view.home_controller.HomeController
import com.toni.mvvm__clean_code.ui.viewModel.HomeViewModel


class Home : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding
    private val controller: HomeController = HomeController()
     private lateinit var calendar:DatePickerDialog
    private var pressBtnStart: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        start()
    }

    private fun start() {

        calendar = DatePickerDialog(this)

        calendar.setOnDateSetListener(DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            val date: String = controller.getBuildDate(year.toString(), month.toString(), dayOfMonth.toString())
            viewModel.loadParams(pressBtnStart, date)

            Toast.makeText(
                this,
                date,
                Toast.LENGTH_SHORT
            ).show()

        })

        calendar.show()


        viewModel.getArticles().observe(this, Observer<List<Article>> { articles ->
            binding.tvWelcome.text = articles.toString()
        })

    }

}
