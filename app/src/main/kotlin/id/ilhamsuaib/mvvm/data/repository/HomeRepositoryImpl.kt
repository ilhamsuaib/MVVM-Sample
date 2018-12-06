package id.ilhamsuaib.mvvm.data.repository

import id.ilhamsuaib.mvvm.data.remote.ApiService
import id.ilhamsuaib.mvvm.presentation.model.Article
import io.reactivex.Single

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

class HomeRepositoryImpl(val api: ApiService) : HomeRepository {

    override fun getArticles(): Single<List<Article>> {
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
    }
}