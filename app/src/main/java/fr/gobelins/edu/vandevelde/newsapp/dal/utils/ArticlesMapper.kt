package fr.gobelins.edu.vandevelde.newsapp.dal.utils

import fr.gobelins.edu.vandevelde.newsapp.dal.online.models.ItemResponse
import fr.gobelins.edu.vandevelde.newsapp.dal.online.models.SourceResponse
import fr.gobelins.edu.vandevelde.newsapp.models.Article
import fr.gobelins.edu.vandevelde.newsapp.models.Source

fun ItemResponse.toArticle() = Article(
    author = author ?: "",
    title = title ?: "",
    description = description ?: "",
    publishedAt = publishedAt ?: "",
    source = source?.toSource() ?: null,
    url = url ?: "",
    urlToImage = urlToImage ?: "",
    content = content ?: ""
)

fun SourceResponse.toSource() = Source(
    id = id ?: "",
    name = name ?: ""
)