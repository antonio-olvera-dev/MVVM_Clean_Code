package com.toni.mvvm__clean_code.ui.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
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
import com.toni.mvvm__clean_code.ui.view.fragments.date_list_fragmet.DateListController
import com.toni.mvvm__clean_code.ui.view.home_controller.HomeController
import com.toni.mvvm__clean_code.ui.viewModel.HomeViewModel

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding
    private val controller: HomeController = HomeController()
    private lateinit var calendar: DatePickerDialog
    private var pressBtnStart: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        start()
    }


    private fun start() {

        viewModel.articleParametersGet.startDate = getString(R.string.start_date)
        viewModel.articleParametersGet.endDate = getString(R.string.end_date)
        calendar = controller.getDatePickerDialog(this.requireContext(), viewModel.articleParametersGet)

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

            if (!articles.isNullOrEmpty()) findNavController().navigate(R.id.dateListFragment)
        })


    }


}