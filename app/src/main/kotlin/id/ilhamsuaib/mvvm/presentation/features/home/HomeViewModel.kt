package id.ilhamsuaib.mvvm.presentation.features.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import id.ilhamsuaib.mvvm.base.BaseViewModel
import id.ilhamsuaib.mvvm.data.repository.HomeRepository
import id.ilhamsuaib.mvvm.presentation.model.Article
import id.ilhamsuaib.mvvm.utils.logD
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

class HomeViewModel(private val repo: HomeRepository) : BaseViewModel() {

    private val tag = HomeViewModel::class.java.simpleName
    val homeSate = MutableLiveData<HomeSate>()
    private val articleList = mutableListOf<Article>()

    init {
        homeSate.value = DefaultState
    }

    fun getArticles() {
        logD(tag, "getArticles")
        val obs = repo.getArticles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onArticleReceived, this::onError)

        disposables.add(obs)
    }

    private fun onArticleReceived(articleList: List<Article>) {
        this.articleList.addAll(articleList)
        homeSate.value = ArticleLoadedState(this.articleList)
    }

    private fun onError(t: Throwable) {
        homeSate.value = ErrorState(t.localizedMessage)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun dispose() {
        if (!disposables.isDisposed)
            disposables.dispose()
    }
}