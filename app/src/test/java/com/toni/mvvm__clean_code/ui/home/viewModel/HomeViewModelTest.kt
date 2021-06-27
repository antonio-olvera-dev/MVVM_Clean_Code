package com.toni.mvvm__clean_code.ui.home.viewModel

import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.data.article.parameters.ArticleParametersGet
import com.toni.mvvm__clean_code.domain.article.use_case.ArticleUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before


class HomeViewModelTest {


    private lateinit var viewModel: HomeViewModel
    private  var articles: List<Article>? = null

    @Before
    fun setUp() {

        viewModel = HomeViewModel()
        viewModel.loadParams(true, "1995-06-19")
        viewModel.loadParams(false, "1995-06-21")

        runBlocking {
            launch {
                articles = ArticleUseCase().getArticles(viewModel.articleParametersGet)
            }
        }
    }


    @Test
    fun loadParams() {

        viewModel.loadParams(true, "1995-06-19")
        viewModel.loadParams(false, "1995-06-21")

        assertEquals("1995-06-19", viewModel.articleParametersGet.startDate)
        assertEquals("1995-06-21", viewModel.articleParametersGet.endDate)
    }

    @Test
    fun getArticleParametersGet() {

        loadParams()
        val param: ArticleParametersGet = viewModel.articleParametersGet

        assertEquals(param.startDate, viewModel.articleParametersGet.startDate)
        assertEquals(param.endDate, viewModel.articleParametersGet.endDate)
    }


    private suspend fun helpLoadArticles(): List<Article> {

        val newArticles = ArticleUseCase().getArticles(viewModel.articleParametersGet)
        articles = newArticles

        return newArticles
    }

    @Test
    fun loadArticles() {
        runBlocking {
            launch {

                assertNotEquals(0, helpLoadArticles())
            }
        }
    }

    @Test
    fun getArticles() {

        assertTrue(articles!!.isNotEmpty())
    }


}