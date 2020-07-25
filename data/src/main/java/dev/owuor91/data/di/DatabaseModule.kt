package dev.owuor91.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.owuor91.data.local.PostsDao
import dev.owuor91.data.local.PostsDatabase
import dev.owuor91.domain.di.DIConstants
import javax.inject.Named

@Module
class DatabaseModule {
    @Provides
    fun providePostsDatabase(@Named(DIConstants.APP) context: Context): PostsDatabase {
        return Room.databaseBuilder<PostsDatabase>(context, PostsDatabase::class.java, "posts_db")
            .build()
    }

    @Provides
    fun providePostsDao(postsDatabase: PostsDatabase): PostsDao {
        return postsDatabase.postsDao()
    }
}
