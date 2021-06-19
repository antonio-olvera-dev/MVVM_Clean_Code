package com.toni.mvvm__clean_code.data.article.service

import com.toni.mvvm__clean_code.data.article.model.Article
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApiClient {

    @GET("")
    fun getArticles(@Query("start_date") startDate: String, @Query("end_date") endDate: String): Response<List<Article>>

}