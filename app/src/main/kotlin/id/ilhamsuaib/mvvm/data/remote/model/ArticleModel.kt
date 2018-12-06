package id.ilhamsuaib.mvvm.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 07/12/18.
 * github.com/ilhamsuaib
 */

class ArticleModel(
    @field:SerializedName("title")
    val title: String?,
    @field:SerializedName("description")
    val description: String?,
    @field:SerializedName("urlToImage")
    val urlToImage: String?,
    @field:SerializedName("publishedAt")
    val publishedAt: String?,
    @field:SerializedName("author")
    val author: String?
)