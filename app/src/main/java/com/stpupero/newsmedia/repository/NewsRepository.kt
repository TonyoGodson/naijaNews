package com.stpupero.newsmedia.repository

import com.stpupero.newsmedia.api.RetrofitInstance
import com.stpupero.newsmedia.db.ArticleDatabase
import com.stpupero.newsmedia.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getallArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}