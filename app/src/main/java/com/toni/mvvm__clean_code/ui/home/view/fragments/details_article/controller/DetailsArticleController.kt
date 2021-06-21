package com.toni.mvvm__clean_code.ui.home.view.fragments.details_article.controller

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.toni.mvvm__clean_code.databinding.DetailsArticleFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class DetailsArticleController {


    fun loadImage(hdUrl: String, binding: DetailsArticleFragmentBinding) {
        GlobalScope.launch(Dispatchers.Main) {
            val url = URL(hdUrl)
            lateinit var bmp: Bitmap
            withContext(Dispatchers.IO) {
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            }

            binding.ivDetailsArticle.setImageBitmap(bmp)
        }
    }
}