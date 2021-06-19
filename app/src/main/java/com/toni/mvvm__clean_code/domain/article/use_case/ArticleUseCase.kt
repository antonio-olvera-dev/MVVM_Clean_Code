package com.toni.mvvm__clean_code.domain.article.use_case

import androidx.lifecycle.LiveData
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.domain.article.repository.ArticleRepository

class ArticleUseCase {

    fun getArticles(): List<Article> {

        return ArticleRepository().getArticles()
    }

}