package id.ilhamsuaib.mvvm.presentation.features.home

import android.os.Bundle
import androidx.lifecycle.Observer
import id.ilhamsuaib.mvvm.R
import id.ilhamsuaib.mvvm.base.BaseActivity
import id.ilhamsuaib.mvvm.utils.extensions.toast
import id.ilhamsuaib.mvvm.utils.logD
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val tag = MainActivity::class.java.simpleName
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.homeSate.observe(this, stateObserver)

        viewModel.getArticles()
    }

    override fun onDestroy() {
        viewModel.dispose()
        super.onDestroy()
    }

    private val stateObserver = Observer<HomeSate> { state ->
        when (state) {
            is DefaultState -> {
                logD(tag, "stateObserver : DefaultState")
                toast("Default State")
            }
            is LoadingState -> {
                logD(tag, "stateObserver : LoadingState")
                toast("Loading State")
            }
            is ErrorState -> {
                logD(tag, "stateObserver : ErrorState")
                toast("Error State")
            }
            is ArticleLoadedState -> {
                logD(tag, "stateObserver : ArticleLoadedState")
                toast("Article Loaded")
            }
        }
    }
}
