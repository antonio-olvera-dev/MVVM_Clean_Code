package com.toni.mvvm__clean_code.data.article.parameters

import org.junit.Assert
import org.junit.Test

class ArticleParametersGetTest{

    @Test
    fun  checkArticleParametersGet(){
       val  aricleParametersGet: ArticleParametersGet = ArticleParametersGet("1995-06-19", "1995-07-19")

        Assert.assertEquals("1995-06-19",aricleParametersGet.startDate)
        Assert.assertEquals("1995-07-19",aricleParametersGet.endDate)
    }
}