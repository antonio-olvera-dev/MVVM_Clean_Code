package com.toni.mvvm__clean_code.ui.home.view.fragments.date_list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.DateListFragmentBinding
import com.toni.mvvm__clean_code.ui.home.shared.HomeBundle
import com.toni.mvvm__clean_code.ui.home.view.fragments.date_list.controller.DateListController


class DateListFragment : Fragment() {

    private var articles: List<Article>? = HomeBundle.articles
    private lateinit var binding: DateListFragmentBinding
    private val controller: DateListController = DateListController()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DateListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.homeFragment)
        }

        start()
    }

    private fun start() {

        val dates = controller.getDates(articles) as List<Article>
        val adapter =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_list_item_1, dates)
        binding.lvHome.adapter = adapter

        binding.lvHome.setOnItemClickListener { adapterView, view, position, l->

            HomeBundle.positionDateSelect = position

            if (!articles.isNullOrEmpty()) findNavController().navigate(R.id.detailsArticleFragment)
        }

    }


}