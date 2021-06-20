package com.toni.mvvm__clean_code.ui.view.fragments.date_list_fragmet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.DateListFragmentBinding
import com.toni.mvvm__clean_code.shared.Constant


class DateListFragment : Fragment() {

    private var articles: List<Article>? = null
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
        articles = arguments?.get(Constant.articles) as List<Article>
        val dates = controller.getDates(articles) as List<Article>
        val adapter =
            ArrayAdapter(this.requireContext(), android.R.layout.simple_list_item_1, dates)
        binding.lvHome.adapter = adapter

        binding.lvHome.setOnItemClickListener { adapterView, view, i, l->

            val bundle = bundleOf(Constant.articles to articles, Constant.position to i)

            if (!articles.isNullOrEmpty()) findNavController().navigate(R.id.detailsArticleFragment, bundle)
        }

    }


}