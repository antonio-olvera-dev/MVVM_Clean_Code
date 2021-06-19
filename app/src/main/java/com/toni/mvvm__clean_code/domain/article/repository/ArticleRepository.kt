package com.toni.mvvm__clean_code.domain.article.repository

import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.data.article.service.ArticleService

class ArticleRepository {

    private val articleService: ArticleService = ArticleService()

    suspend fun getArticles(): List<Article> {

        return articleService.getArticles()
    }

}