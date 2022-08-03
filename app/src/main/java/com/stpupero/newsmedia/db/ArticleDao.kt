package com.stpupero.newsmedia.db

import com.stpupero.newsmedia.models.Article
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getallArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}