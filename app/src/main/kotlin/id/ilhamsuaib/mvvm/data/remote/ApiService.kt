package id.ilhamsuaib.mvvm.data.remote

import id.ilhamsuaib.mvvm.data.remote.model.ArticleResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by @ilhamsuaib on 07/12/18.
 * github.com/ilhamsuaib
 */

interface ApiService {

    @GET("top-headlines?country=id")
    fun getArticles(): Observable<ArticleResponseModel>
}