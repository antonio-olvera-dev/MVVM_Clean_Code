package com.toni.mvvm__clean_code.data.article.service

import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.gateway.retrofit.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticleService {

        private val retrofit = RetrofitHelper.getRetrofit()


    suspend fun getArticles(): List<Article> {

            return withContext(Dispatchers.IO) {

                val response = retrofit.create(ArticleService::class.java).getArticles()
                response ?: emptyList()
            }
    }

}