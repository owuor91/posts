package dev.owuor91.data.repository

import dev.owuor91.data.local.PostsDao
import dev.owuor91.data.mappers.PostsMapper
import dev.owuor91.domain.models.Post
import dev.owuor91.domain.repository.PostsRepository
import io.reactivex.Flowable
import io.reactivex.Single

class PostsDbRepository(private var postsDao: PostsDao) : PostsRepository {
    override fun getPosts(): Single<List<Post>> {
        return postsDao.getPosts()
            .flatMapPublisher { posts -> Flowable.fromIterable(posts) }
            .map { post -> PostsMapper.transform(post) }
            .toList()
    }

    override fun savePost(post: Post): Single<Post> {
        return Single.just(post)
            .map { post -> PostsMapper.transform(post) }
            .map { postDatabaseModel -> postsDao.insertPost(postDatabaseModel) }
            .map { l -> post }
    }
}