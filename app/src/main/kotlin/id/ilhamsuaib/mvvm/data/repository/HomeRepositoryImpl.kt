package id.ilhamsuaib.mvvm.data.repository

import id.ilhamsuaib.mvvm.data.local.entity.ArticleEntity
import id.ilhamsuaib.mvvm.data.remote.ApiService
import id.ilhamsuaib.mvvm.presentation.model.Article
import id.ilhamsuaib.mvvm.utils.logD
import io.reactivex.Observable

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

class HomeRepositoryImpl(val api: ApiService) : HomeRepository {

    override fun insertToDb(article: ArticleEntity) {

    }

    private val tag = HomeRepositoryImpl::class.java.simpleName

    override fun getArticles(): Observable<List<Article>> {
        logD(tag, "getArticles")
        return api.getArticles()
                .flatMapIterable { it.articles }
                .map {
                    Article(
                            author = it.author,
                            description = it.description,
                            title = it.title,
                            publishedAt = it.publishedAt,
                            urlToImage = it.urlToImage
                    )
                }
                .toList()
                .toObservable()
    }
}