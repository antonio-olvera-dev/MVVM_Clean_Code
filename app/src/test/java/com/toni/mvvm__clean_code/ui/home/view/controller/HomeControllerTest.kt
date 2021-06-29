package com.toni.mvvm__clean_code.ui.home.view.controller

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.toni.mvvm__clean_code.data.article.parameters.ArticleParametersGet
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class HomeControllerTest {

    private lateinit var homeController: HomeController
    private lateinit var articleParametersGet: ArticleParametersGet

//    private val ctx: Context = ApplicationProvider.getApplicationContext()

    @Before
    fun setUp() {
        homeController = HomeController()
        articleParametersGet = ArticleParametersGet("1995-06-19", "1995-06-21")

    }


//    @Test
//    fun getDatePickerDialog() {
//
//
//        val year: Int =
//            homeController.getDatePickerDialog(ctx, articleParametersGet).datePicker.year
//
//        assertEquals(1995, year)
//    }

    @Test
    fun getBuildDate() {

        val dateTransformed = homeController.getBuildDate("1995", 5, "19")

        assertEquals("1995-06-19", dateTransformed)

    }
}