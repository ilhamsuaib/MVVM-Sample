package id.ilhamsuaib.mvvm.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ilhamsuaib.mvvm.data.local.entity.ArticleEntity
import id.ilhamsuaib.mvvm.utils.Constants
import io.reactivex.Observable

/**
 * Created by @ilhamsuaib on 17/12/18.
 * github.com/ilhamsuaib
 */

@Dao
interface ArticleDao {

    @Query("SELECT * FROM ${Constants.DB.ARTICLE}")
    fun getAll(): Observable<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: ArticleEntity)
}