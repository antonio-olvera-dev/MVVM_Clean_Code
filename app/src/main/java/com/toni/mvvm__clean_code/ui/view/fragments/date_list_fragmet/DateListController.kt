package com.toni.mvvm__clean_code.ui.view.fragments.date_list_fragmet

import android.util.Log
import androidx.lifecycle.LiveData
import com.toni.mvvm__clean_code.data.article.model.Article


class DateListController {

    fun getDates(articles: List<Article>?):List<String>{

        val dates: MutableList<String> = arrayListOf()
        articles?.iterator()?.forEach { article ->
            dates.add(article.date)
        }

        return dates
    }



}