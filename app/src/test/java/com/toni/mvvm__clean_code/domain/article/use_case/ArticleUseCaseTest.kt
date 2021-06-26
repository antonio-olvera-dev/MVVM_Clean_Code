package com.toni.mvvm__clean_code.domain.article.use_case

import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.data.article.parameters.ArticleParametersGet
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class ArticleUseCaseTest {

    private val articleUseCase: ArticleUseCase = ArticleUseCase()
    private val articleParametersGet: ArticleParametersGet =
        ArticleParametersGet("1995-06-19", "1995-06-21")

    @Test
    fun testGetArticles() {

        runBlocking {
            launch {
                val article: List<Article> = articleUseCase.getArticles(articleParametersGet)

                assertTrue(article.isNotEmpty())
            }
        }

    }
}