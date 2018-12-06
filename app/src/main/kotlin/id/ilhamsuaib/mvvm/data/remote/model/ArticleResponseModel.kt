package id.ilhamsuaib.mvvm.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 07/12/18.
 * github.com/ilhamsuaib
 */

data class ArticleResponseModel(
    @field:SerializedName("status")
    val status: String?,
    @field:SerializedName("totalResults")
    val totalResults: Int?,
    @field:SerializedName("articles")
    val articles: List<ArticleModel>
)