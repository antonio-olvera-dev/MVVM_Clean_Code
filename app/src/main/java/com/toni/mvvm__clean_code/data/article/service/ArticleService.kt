package com.toni.mvvm__clean_code.data.article.service

import android.util.Log
import com.toni.mvvm__clean_code.data.article.parameters.ArticleParametersGet
import com.toni.mvvm__clean_code.data.article.model.Article
import com.toni.mvvm__clean_code.gateway.retrofit.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

import java.lang.Exception

class ArticleService {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val retrofitCreate = retrofit.create(ArticleApiClient::class.java)

    suspend fun getArticles(articleParametersGet: ArticleParametersGet): List<Article> {

        return withContext(Dispatchers.IO) {

            try {

                val call: Call<List<Article>> = retrofitCreate.getArticles(
                    "DEMO_KEY",
                    articleParametersGet.startDate,
                    articleParametersGet.endDate
                )
                call.execute().body() ?: emptyList()
            } catch (e: Exception) {
                Log.w("ERROR into ArticleService: ",e)
                emptyList()
            }
        }
    }

}