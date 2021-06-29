package com.toni.mvvm__clean_code.ui.home.view.controller


import com.toni.mvvm__clean_code.data.article.parameters.ArticleParametersGet
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class HomeControllerTest {

    private lateinit var homeController: HomeController
    private lateinit var articleParametersGet: ArticleParametersGet

    @Before
    fun setUp() {
        homeController = HomeController()
        articleParametersGet = ArticleParametersGet("1995-06-19", "1995-06-21")

    }


    @Test
    fun getBuildDate() {

        val dateTransformed = homeController.getBuildDate("1995", 5, "19")

        assertEquals("1995-06-19", dateTransformed)

    }
}