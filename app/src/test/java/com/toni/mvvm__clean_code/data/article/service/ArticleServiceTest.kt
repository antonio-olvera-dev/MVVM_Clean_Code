package com.toni.mvvm__clean_code.data.article.service

import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.data.article.parameters.ArticleParametersGet
import junit.framework.TestCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ArticleServiceTest {


    private lateinit var articleService: ArticleService
    private val articleParametersGet: ArticleParametersGet =
        ArticleParametersGet("1995-06-19", "1995-06-21")

    @Before
    fun setup() {
        articleService = ArticleService()
    }

    @Test
    fun testGetArticles() {

        runBlocking {
            launch {
                val article: List<Article> = articleService.getArticles(articleParametersGet)

                Assert.assertTrue(article.isNotEmpty())
            }
        }

    }


}