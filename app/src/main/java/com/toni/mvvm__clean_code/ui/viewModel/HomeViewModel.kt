package com.toni.mvvm__clean_code.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.toni.mvvm__clean_code.data.article.article_parameters.ArticleParametersGet
import com.toni.mvvm__clean_code.data.article.article_parameters.IArticleParametersGet
import com.toni.mvvm__clean_code.data.article.model.Article

class HomeViewModel : ViewModel(), IArticleParametersGet {

    override val articleParametersGet: ArticleParametersGet = ArticleParametersGet("", "")

    private val articles: MutableLiveData<List<Article>> by lazy {
        MutableLiveData<List<Article>>().also {
            loadStartup()
        }
    }

    fun getArticles(): LiveData<List<Article>> {

        return articles
    }

    fun loadStartup(){


    }

    fun loadParams(pressBtnStart: Boolean, date: String){
        if (pressBtnStart) articleParametersGet.startDate = date else articleParametersGet.endDate = date
    }

    fun loadArticles(articleParametersGet: ArticleParametersGet){

    }


}
