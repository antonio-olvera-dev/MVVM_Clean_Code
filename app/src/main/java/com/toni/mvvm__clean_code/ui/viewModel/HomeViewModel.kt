package com.toni.mvvm__clean_code.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.toni.mvvm__clean_code.data.models.Article

class HomeViewModel : ViewModel() {

    private val articles: MutableLiveData<List<Article>> by lazy {
        MutableLiveData<List<Article>>().also {

        }
    }

    fun getArticles(): LiveData<List<Article>> {


        return articles
    }


}
