package dev.owuor91.data.local

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Posts")
data class PostsDbModel(
    @PrimaryKey @NonNull var id: Int,
    var userId: Int,
    var title: String,
    var body: String
)