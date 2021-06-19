package com.toni.mvvm__clean_code.data.article.article_parameters

/**
 * Article parameters get
 *
 * start_date: 1995-06-19
 * @property startDate
 * end_date: 1995-06-19
 * @property endDate
 * @constructor Create empty Article parameters get
 */
data class ArticleParametersGet(var startDate: String, var endDate: String)

interface IArticleParametersGet {

    val articleParametersGet: ArticleParametersGet
}