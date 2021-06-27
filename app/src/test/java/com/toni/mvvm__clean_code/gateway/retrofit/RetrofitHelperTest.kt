package com.toni.mvvm__clean_code.gateway.retrofit

import com.toni.mvvm__clean_code.shared.Constant
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class RetrofitHelperTest {

    private val retrofitHelper: RetrofitHelper = RetrofitHelper

    @Test
    fun testGetRetrofit() {

        assertTrue(retrofitHelper.getRetrofit().baseUrl().toString() == Constant.baseUrl)

    }
}