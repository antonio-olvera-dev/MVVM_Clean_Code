package com.toni.mvvm__clean_code.domain.article.repository

import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.data.article.service.ArticleService

class ArticleRepository {

    fun getArticles(): List<Article> {

        return ArticleService().getArticles()
    }

}