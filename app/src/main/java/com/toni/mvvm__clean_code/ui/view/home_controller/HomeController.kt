package com.toni.mvvm__clean_code.ui.view.home_controller

class HomeController {


    fun getBuildDate(year: String, month: String, dayOfMonth: String): String {

        var newDate: String = year
        newDate += if (month.length > 1) month else "0$month"
        newDate += if (dayOfMonth.length > 1) dayOfMonth else "0$dayOfMonth"

        return newDate
    }


}