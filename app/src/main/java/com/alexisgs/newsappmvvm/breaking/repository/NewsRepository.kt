package com.alexisgs.newsappmvvm.breaking.repository

import com.alexisgs.newsappmvvm.breaking.data.api.RetrofitInstance
import com.alexisgs.newsappmvvm.breaking.data.db.ArticleDao
import com.alexisgs.newsappmvvm.breaking.data.db.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.breakingApi.getBreakingNews(countryCode, pageNumber)
}