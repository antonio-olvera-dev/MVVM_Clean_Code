package com.toni.mvvm__clean_code.ui.view

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.ActivityHomeBinding
import com.toni.mvvm__clean_code.ui.view.home_controller.HomeController
import com.toni.mvvm__clean_code.ui.viewModel.HomeViewModel


class HomeView : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding
    private val controller: HomeController = HomeController()
    private lateinit var calendar: DatePickerDialog
    private var pressBtnStart: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        start()
    }

    private fun start() {

        viewModel.articleParametersGet.startDate = getString(R.string.start_date)
        viewModel.articleParametersGet.endDate = getString(R.string.end_date)
        calendar = DatePickerDialog(this)

        calendar.setOnDateSetListener(DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            val date: String =
                controller.getBuildDate(year.toString(), month.toString(), dayOfMonth.toString())

            if (pressBtnStart) {
                binding.homeBtStartDate.text = date
            } else {
                binding.homeBtEndingDate.text = date
            }

            viewModel.loadParams(pressBtnStart, date)
        })

        binding.homeBtStartDate.setOnClickListener {
            pressBtnStart = true
            calendar.show()
        }

        binding.homeBtEndingDate.setOnClickListener {
            pressBtnStart = false
            calendar.show()
        }

        binding.ibRocket.setOnClickListener {
            viewModel.loadArticles()
        }

        viewModel.getArticles().observe(this, Observer<List<Article>> { articles ->
//            binding.tvWelcome.text = articles.toString()
        })

    }

}
