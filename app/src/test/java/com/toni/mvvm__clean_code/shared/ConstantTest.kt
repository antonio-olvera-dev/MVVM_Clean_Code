package com.toni.mvvm__clean_code.shared

import org.junit.Assert
import org.junit.Test

class ConstantTest{

    @Test
    fun checkConstant(){
        Assert.assertEquals("https://api.nasa.gov/",Constant.baseUrl)
    }
}