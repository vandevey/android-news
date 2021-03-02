package fr.gobelins.edu.vandevelde.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.gobelins.edu.vandevelde.newsapp.models.Article
import fr.gobelins.edu.vandevelde.newsapp.repositories.ArticleRepository
import java.util.concurrent.Executors


class HomeViewModel : ViewModel() {

    private val repository: ArticleRepository = ArticleRepository.getInstance()
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>>
        get() = _articles

    init {
        loadArticles("Covid")
    }

    fun loadArticles(query: String) {
        Executors.newSingleThreadExecutor().execute{
            val result = repository.getArticles(query)
            _articles.postValue(result.value)
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}