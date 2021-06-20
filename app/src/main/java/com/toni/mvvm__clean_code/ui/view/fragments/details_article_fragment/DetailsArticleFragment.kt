package com.toni.mvvm__clean_code.ui.view.fragments.details_article_fragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.DetailsArticleFragmentBinding
import com.toni.mvvm__clean_code.shared.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL


class DetailsArticleFragment : Fragment() {

    private var articles: List<Article>? = null
    private var position: Int = 0
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

        articles = arguments?.get(Constant.articles) as List<Article>
        position = arguments?.get(Constant.position) as Int
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            val bundle = bundleOf(Constant.articles to articles)
            findNavController().navigate(R.id.dateListFragment, bundle)
        }

        start()
    }

    fun start() {

        val article: Article? = articles?.get(position)

        binding.tvDetailsArticleTitle.text = article?.title
        binding.tvDetailsArticleExplanation.text = article?.explanation
        controller.loadImage(article?.hdUrl ?: "https://i.stack.imgur.com/6M513.png", binding)

    }

}