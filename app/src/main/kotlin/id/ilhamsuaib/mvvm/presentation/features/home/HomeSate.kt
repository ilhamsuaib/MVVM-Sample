package id.ilhamsuaib.mvvm.presentation.features.home

import id.ilhamsuaib.mvvm.presentation.model.Article

/**
 * Created by @ilhamsuaib on 12/12/18.
 * github.com/ilhamsuaib
 */

sealed class HomeSate

object DefaultState : HomeSate()
data class ArticleLoadedState(val articles: List<Article>) : HomeSate()
object LoadingState : HomeSate()
data class ErrorState(val errorMessage: String) : HomeSate()