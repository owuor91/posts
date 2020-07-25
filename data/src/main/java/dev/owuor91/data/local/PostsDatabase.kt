package dev.owuor91.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PostsDbModel::class], version = 1)
public abstract class PostsDatabase : RoomDatabase() {
    abstract fun postsDao(): PostsDao
}