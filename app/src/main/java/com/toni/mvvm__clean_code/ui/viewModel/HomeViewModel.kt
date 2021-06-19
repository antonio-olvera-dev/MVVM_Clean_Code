package com.toni.mvvm__clean_code.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toni.mvvm__clean_code.data.article.article_parameters.ArticleParametersGet
import com.toni.mvvm__clean_code.data.article.article_parameters.IArticleParametersGet
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.domain.article.use_case.ArticleUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(), IArticleParametersGet {

    override val articleParametersGet: ArticleParametersGet = ArticleParametersGet("1995-06-19", "1995-06-25")
    val useCase: ArticleUseCase = ArticleUseCase()

    private val articles: MutableLiveData<List<Article>> by lazy {
        MutableLiveData<List<Article>>().also {
            loadStartup()
        }
    }

    fun getArticles(): LiveData<List<Article>> {

        return articles
    }

    private fun loadStartup() {
        viewModelScope.launch {
            val newArticles = useCase.getArticles(articleParametersGet)
            if (!newArticles.isNullOrEmpty()) {
                articles.postValue(newArticles)
            }
        }

    }

    fun loadParams(pressBtnStart: Boolean, date: String) {
        if (pressBtnStart) articleParametersGet.startDate = date else articleParametersGet.endDate =
            date
    }

    fun loadArticles(articleParametersGet: ArticleParametersGet) {

    }


}
