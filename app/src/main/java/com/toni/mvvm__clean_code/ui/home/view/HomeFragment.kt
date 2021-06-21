package com.toni.mvvm__clean_code.ui.home.view

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.HomeFragmentBinding
import com.toni.mvvm__clean_code.ui.home.shared.HomeBundle
import com.toni.mvvm__clean_code.ui.home.view.controller.HomeController
import com.toni.mvvm__clean_code.ui.home.viewModel.HomeViewModel

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding
    private val controller: HomeController = HomeController()
    private lateinit var calendar: DatePickerDialog
    private var pressBtnStart: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start()
    }


    private fun start() {

        HomeBundle.clearMemory()
        viewModel.articleParametersGet.startDate = getString(R.string.start_date)
        viewModel.articleParametersGet.endDate = getString(R.string.end_date)
        calendar =
            controller.getDatePickerDialog(this.requireContext(), viewModel.articleParametersGet)

        launchDateListener()

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

        viewModel.getArticles().observe(viewLifecycleOwner, Observer<List<Article>> { articles ->

            HomeBundle.articles = articles

            if (!articles.isNullOrEmpty()) findNavController().navigate(R.id.dateListFragment)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer<Boolean> { loading ->

            if (loading) binding.progressBarInclude.progressBarParent.visibility = View.VISIBLE
            else binding.progressBarInclude.progressBarParent.visibility = View.GONE

        })

    }

    private fun launchDateListener() {
        calendar.setOnDateSetListener(DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            val date: String =
                controller.getBuildDate(year.toString(), month, dayOfMonth.toString())

            if (pressBtnStart) {
                binding.homeBtStartDate.text = date
            } else {
                binding.homeBtEndingDate.text = date
            }

            viewModel.loadParams(pressBtnStart, date)
        })
    }

}