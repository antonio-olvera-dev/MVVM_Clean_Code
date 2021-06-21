package com.toni.mvvm__clean_code.ui.home.view.fragments.details_article.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.DetailsArticleFragmentBinding
import com.toni.mvvm__clean_code.ui.home.shared.HomeBundle
import com.toni.mvvm__clean_code.ui.home.view.fragments.details_article.controller.DetailsArticleController


class DetailsArticleFragment : Fragment() {

    private var articles: List<Article>? = HomeBundle.articles
    private var position: Int = HomeBundle.positionDateSelect
    private lateinit var binding: DetailsArticleFragmentBinding
    private val controller: DetailsArticleController = DetailsArticleController()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsArticleFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {

            findNavController().navigate(R.id.dateListFragment)
        }

        start()
    }

    private fun start() {

        val article: Article? = articles?.get(position)

        binding.tvDetailsArticleTitle.text = article?.title
        binding.tvDetailsArticleExplanation.text = article?.explanation
        controller.loadImage(article?.hdUrl ?: "https://i.stack.imgur.com/6M513.png", binding)

    }

}