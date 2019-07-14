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

    fun getArticles() {
        logD(tag, "getArticles")
        val obs = repo.getArticles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                showProgress(true)
            }
            .doOnComplete {
                showProgress(false)
            }
            .subscribe(this::onArticleReceived, this::onError)

        disposables.add(obs)
    }

    private fun showProgress(show: Boolean) {
        homeSate.value = HomeSate.LoadingState(show)
    }

    private fun onArticleReceived(articleList: List<Article>) {
        this.articleList.addAll(articleList)
        homeSate.value = HomeSate.ArticleLoadedState(this.articleList)
    }

    private fun onError(t: Throwable) {
        homeSate.value = HomeSate.ErrorState(t)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun dispose() {
        if (!disposables.isDisposed)
            disposables.dispose()
    }

    fun restoreObservedData() {
        homeSate.value = HomeSate.ArticleLoadedState(this.articleList)
    }
}