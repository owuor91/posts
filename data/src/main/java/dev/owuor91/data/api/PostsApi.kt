package dev.owuor91.data.api

import dev.owuor91.domain.models.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostsApi {
    @GET("posts")
    fun getPosts(): Single<List<Post>>
}