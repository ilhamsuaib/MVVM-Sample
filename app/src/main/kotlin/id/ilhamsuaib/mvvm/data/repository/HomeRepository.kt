package id.ilhamsuaib.mvvm.data.repository

import id.ilhamsuaib.mvvm.presentation.model.Article
import io.reactivex.Single

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

interface HomeRepository {

    fun getArticles(): Single<List<Article>>
}