package com.toni.mvvm__clean_code.gateway.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/apod?api_key=DEMO_KEY&")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}