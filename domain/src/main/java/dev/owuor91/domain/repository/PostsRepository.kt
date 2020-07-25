package dev.owuor91.domain.repository

import dev.owuor91.domain.models.Post
import io.reactivex.Single

interface PostsRepository {
    fun getPosts(): Single<List<Post>>
}