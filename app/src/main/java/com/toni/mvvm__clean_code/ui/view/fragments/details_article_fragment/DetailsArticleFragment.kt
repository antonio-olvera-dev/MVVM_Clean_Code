package com.toni.mvvm__clean_code.ui.view.fragments.details_article_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.toni.mvvm__clean_code.R
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.databinding.DateListFragmentBinding
import com.toni.mvvm__clean_code.databinding.DetailsArticleFragmentBinding
import com.toni.mvvm__clean_code.shared.Constant
import com.toni.mvvm__clean_code.ui.view.fragments.date_list_fragmet.DateListController


private const val ARG_PARAM1 = "param1"

class DetailsArticleFragment : Fragment() {

    private var articles: List<Article>? = null
    private lateinit var binding: DetailsArticleFragmentBinding
    private val controller: DetailsArticleController = DetailsArticleController()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_article_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articles = arguments?.get(Constant.articles) as List<Article>
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            val bundle = bundleOf(Constant.articles to articles)
            findNavController().navigate(R.id.dateListFragment, bundle)
        }

    }

}