package dev.owuor91.presentation

import dev.owuor91.domain.models.Post
import dev.owuor91.domain.repository.PostsRepository
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostsPresenterTest {
    @Rule
    @JvmField
    var trampolineSchedulerRule = TrampolineSchedulerRule()

    @Mock
    lateinit var postsApiRepository: PostsRepository

    @Mock
    lateinit var view: PostsPresenter.View

    @Test
    fun shouldDisplayPosts() {
        var posts = listOf(
            Post(1, 2, "A title", "A body"),
            Post(2, 3, "A title 2", "A body 2"),
            Post(3, 4, "A title 3", "A body 3")
        )

        Mockito.`when`(postsApiRepository?.getPosts()).thenReturn(Single.just(posts))
        var postsPresenter = PostsPresenter(postsApiRepository)
        postsPresenter.view = view
        postsPresenter.getRemotePosts()
        Mockito.verify(view).displayPosts(posts)
    }
}