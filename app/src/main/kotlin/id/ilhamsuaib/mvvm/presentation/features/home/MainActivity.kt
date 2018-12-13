package id.ilhamsuaib.mvvm.presentation.features.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.ilhamsuaib.mvvm.R
import id.ilhamsuaib.mvvm.base.BaseActivity
import id.ilhamsuaib.mvvm.presentation.model.Article
import id.ilhamsuaib.mvvm.utils.extensions.toJson
import id.ilhamsuaib.mvvm.utils.extensions.toast
import id.ilhamsuaib.mvvm.utils.logD
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity(), Observer<HomeSate> {

    private val tag = MainActivity::class.java.simpleName
    private val viewModel: HomeViewModel by viewModel()
    private val articleList: MutableList<Article> = mutableListOf()
    private val articleAdapter = ArticleAdapter(articleList, this::onItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.homeSate.observe(this, this)

        setupView()

        viewModel.getArticles()
    }

    private fun setupView() {
        rvArticles.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = articleAdapter
        }
    }

    override fun onDestroy() {
        viewModel.dispose()
        super.onDestroy()
    }

    override fun onChanged(state: HomeSate?) {
        when (state) {
            is HomeSate.LoadingState -> showProgress(state.show)
            is HomeSate.ErrorState -> onError(state.t)
            is HomeSate.ArticleLoadedState -> showArticles(state.articles)
        }
    }

    private fun onItemClick(article: Article) {
        logD(tag, "onItemClick: ${article.toJson()}")
        toast(article.title)
    }

    private fun showArticles(articles: List<Article>) {
        toast("Show articles : ${articles.size}")

        this.articleList.addAll(articles)
        val positionStart = articleAdapter.itemCount
        val itemCount = this.articleList.size
        articleAdapter.notifyItemRangeChanged(positionStart, itemCount)
    }

    private fun showProgress(show: Boolean) {
        toast("Show progress : $show")
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun onError(t: Throwable) {
        toast("On error : ${t.localizedMessage}")
    }
}
