package dev.owuor91.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(postsDbModel: PostsDbModel): Long

    @Query("SELECT * FROM Posts")
    fun getPosts(): Single<List<PostsDbModel>>
}