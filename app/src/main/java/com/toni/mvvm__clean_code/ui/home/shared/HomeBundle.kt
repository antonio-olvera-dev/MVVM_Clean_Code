package com.toni.mvvm__clean_code.ui.home.shared

import com.toni.mvvm__clean_code.data.article.model.Article

object HomeBundle {

    var articles: List<Article> = arrayListOf()
    var positionDateSelect: Int = 0

    fun clearMemory(){
        articles =  arrayListOf()
        positionDateSelect = 0
    }

}