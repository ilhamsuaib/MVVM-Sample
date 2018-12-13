package id.ilhamsuaib.mvvm.presentation.features.home

import id.ilhamsuaib.mvvm.presentation.model.Article

/**
 * Created by @ilhamsuaib on 12/12/18.
 * github.com/ilhamsuaib
 */

sealed class HomeSate {
    data class ArticleLoadedState(val articles: List<Article>) : HomeSate()
    data class LoadingState(val show: Boolean) : HomeSate()
    data class ErrorState(val t: Throwable) : HomeSate()
}