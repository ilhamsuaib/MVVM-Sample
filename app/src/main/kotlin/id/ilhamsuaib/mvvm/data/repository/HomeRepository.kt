package id.ilhamsuaib.mvvm.data.repository

import id.ilhamsuaib.mvvm.data.local.entity.ArticleEntity
import id.ilhamsuaib.mvvm.presentation.model.Article
import io.reactivex.Observable

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

interface HomeRepository {

    fun getArticles(): Observable<List<Article>>

    fun insertToDb(article: ArticleEntity)
}