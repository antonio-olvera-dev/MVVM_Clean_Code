package com.toni.mvvm__clean_code.domain.article.use_case

import com.toni.mvvm__clean_code.data.article.parameters.ArticleParametersGet
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.domain.article.repository.ArticleRepository

class ArticleUseCase {

    suspend  fun getArticles(articleParametersGet: ArticleParametersGet): List<Article> {
        return ArticleRepository().getArticles(articleParametersGet)
    }

}