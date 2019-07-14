package id.ilhamsuaib.mvvm.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import id.ilhamsuaib.mvvm.utils.Constants

/**
 * Created by @ilhamsuaib on 17/12/18.
 * github.com/ilhamsuaib
 */

@Entity(
    tableName = Constants.DB.ARTICLE,
    indices = [Index(value = [ArticleEntity.TITLE], unique = true)]
)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id: Int,

    @ColumnInfo(name = TITLE)
    val title: String?,

    @ColumnInfo(name = DESCRIPTION)
    val description: String?,

    @ColumnInfo(name = URL_TO_IMAGE)
    val urlToImage: String?,

    @ColumnInfo(name = PUBLISHED_AT)
    val publishedAt: String?,

    @ColumnInfo(name = AUTHOR)
    val author: String?
) {

    companion object {
        const val ID = "id"
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val URL_TO_IMAGE = "urlToImage"
        const val PUBLISHED_AT = "publishedAt"
        const val AUTHOR = "author"
    }
}