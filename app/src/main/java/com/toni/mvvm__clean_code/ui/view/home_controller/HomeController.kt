package com.toni.mvvm__clean_code.ui.view.home_controller

import android.app.DatePickerDialog
import android.content.Context
import com.toni.mvvm__clean_code.data.article.article_parameters.ArticleParametersGet

class HomeController {

    fun getDatePickerDialog(
        ctx: Context,
        articleParametersGet: ArticleParametersGet
    ): DatePickerDialog {

        val datePickerDialog: DatePickerDialog = DatePickerDialog(ctx)
        val arrayDate: List<String> = articleParametersGet.startDate.split("-")

        datePickerDialog.updateDate(arrayDate[0].toInt(), arrayDate[1].toInt(), arrayDate[2].toInt())

        return datePickerDialog
    }

    fun getBuildDate(year: String, month: Int, dayOfMonth: String): String {

        val monthFix: String = "${(month + 1)}"
        var newDate: String = "$year-"

        newDate += if (monthFix.length > 1) "$monthFix-" else "0$monthFix-"
        newDate += if (dayOfMonth.length > 1) dayOfMonth else "0$dayOfMonth"

        return newDate
    }


}