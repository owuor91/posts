package dev.owuor91.data.repository

import dev.owuor91.data.api.PostsApi
import dev.owuor91.domain.models.Post
import dev.owuor91.domain.repository.PostsRepository
import io.reactivex.Single

class PostsApiRepository(private val postsApi: PostsApi) : PostsRepository {

    override fun getPosts(): Single<List<Post>> {
        return postsApi.getPosts()
    }

    override fun savePost(post: Post): Single<Post> {
        TODO()
    }
}