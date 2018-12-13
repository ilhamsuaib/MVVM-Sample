package id.ilhamsuaib.mvvm.presentation.features.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.ilhamsuaib.mvvm.R
import id.ilhamsuaib.mvvm.presentation.model.Article
import kotlinx.android.synthetic.main.item_home_article.view.*

/**
 * Created by @ilhamsuaib on 14/12/18.
 * github.com/ilhamsuaib
 */

class ArticleAdapter(private val articleList: List<Article>,
                     private val onItemClick: (article: Article) -> Unit) : RecyclerView.Adapter<ArticleAdapter.ArticleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_home_article, parent, false)
        return ArticleHolder(view)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        val article = articleList[position]
        holder.bind(article)
        holder.itemView.setOnClickListener {
            onItemClick(article)
        }
    }

    inner class ArticleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(article: Article) = with(itemView) {
            Glide.with(context)
                    .load(article.urlToImage)
                    .into(imgArticle)

            tvTitle.text = article.title
        }
    }
}