package dev.owuor91.data.mappers

import dev.owuor91.data.local.PostsDbModel
import dev.owuor91.domain.models.Post

class PostsMapper {
    companion object {
        fun transform(post: Post): PostsDbModel {
            return PostsDbModel(post.id, post.userId, post.title, post.body)
        }

        fun transform(postDbModel: PostsDbModel): Post {
            return Post(postDbModel.id, postDbModel.userId, postDbModel.title, postDbModel.body)
        }
    }
}