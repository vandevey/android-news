package fr.gobelins.edu.vandevelde.newsapp.dal

import androidx.lifecycle.LiveData
import fr.gobelins.edu.vandevelde.newsapp.models.Article

interface NewsDataSource {
    fun getArticles(query: String): LiveData<List<Article>>
}