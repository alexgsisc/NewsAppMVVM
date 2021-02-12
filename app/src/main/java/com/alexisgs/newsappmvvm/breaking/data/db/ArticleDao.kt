package com.alexisgs.newsappmvvm.breaking.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.alexisgs.newsappmvvm.breaking.data.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setArticle(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}