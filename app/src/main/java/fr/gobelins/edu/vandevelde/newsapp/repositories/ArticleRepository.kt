package fr.gobelins.edu.vandevelde.newsapp.repositories

import androidx.lifecycle.LiveData
import fr.gobelins.edu.vandevelde.newsapp.dal.NewsDataSource
import fr.gobelins.edu.vandevelde.newsapp.dal.online.ArticleOnlineService
import fr.gobelins.edu.vandevelde.newsapp.models.Article

class ArticleRepository {
    private val dataSource: NewsDataSource = ArticleOnlineService()
    fun getArticles(query: String): LiveData<List<Article>> {
        return dataSource.getArticles(query)
    }

    companion object {
        private var instance: ArticleRepository? = null
        fun getInstance(): ArticleRepository {
            if (instance == null){
                instance = ArticleRepository()
            }
            return instance!!
        }
    }
}