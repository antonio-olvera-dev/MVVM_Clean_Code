package com.toni.mvvm__clean_code.ui.home.view.fragments.date_list.controller

import com.toni.mvvm__clean_code.data.article.model.Article
import org.junit.Test

import org.junit.Assert.*

class DateListControllerTest {

    private val dateListController: DateListController = DateListController()
    private val article: Article = Article(
        "1995-06-20",
        "Today's Picture: June 20, 1995    The Pleiades Star Cluster  Picture Credit: Mount Wilson Observatory  Explanation:  The Pleiades star cluster, M45, is one of the brightest star clusters visible in the northern hemisphere. It consists of many bright, hot stars that were all formed at the same time within a large cloud of interstellar dust and gas. The blue haze that accompanies them is due to very fine dust which still remains and preferentially reflects the blue light from the stars.   We keep an archive of previous Astronomy Pictures of the Day.   Astronomy Picture of the Day is brought to you by  Robert Nemiroff and  Jerry Bonnell . Original material on this page is copyrighted to Robert J. Nemiroff and Jerry T. Bonnell.",
        "https://apod.nasa.gov/apod/image/pleiades2.gif",
        "image",
        "v1",
        "Pleiades Star Cluster",
        "https://apod.nasa.gov/apod/image/pleiades2.gif"
    )


    @Test
    fun getDates() {

        val articles: List<Article> = arrayListOf(article, article, article, article)
        val dateList: List<String> = dateListController.getDates(articles)

        assertEquals(article, articles[0])
        assertEquals(dateList[0], article.date)
    }
}