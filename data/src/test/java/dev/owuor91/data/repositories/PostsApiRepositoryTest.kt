package dev.owuor91.data.repositories

import dev.owuor91.data.api.PostsApi
import dev.owuor91.data.repository.PostsApiRepository
import dev.owuor91.domain.models.Post
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostsApiRepositoryTest {
    @Mock
    lateinit var postsApi: PostsApi
    lateinit var posts: List<Post>

    @Before
    fun setup() {
        posts = listOf(
            Post(1, 2, "A title", "A body"),
            Post(2, 3, "A title 2", "A body 2"),
            Post(3, 4, "A title 3", "A body 3")
        )
    }

    @Test
    fun shouldFetchPosts() {
        Mockito.`when`(postsApi.getPosts()).thenReturn(Single.just(posts))
        var postsApiRepository = PostsApiRepository(postsApi)
        var testObserver = postsApiRepository.getPosts().test()
        testObserver.awaitTerminalEvent()
        testObserver.assertValue { posts -> posts[1].body.equals("A body 2") }
    }
}