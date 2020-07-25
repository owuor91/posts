package dev.owuor91.posts

import android.os.Bundle
import android.widget.Toast
import dev.owuor91.domain.models.Post
import dev.owuor91.posts.ui.activities.BaseActivity
import dev.owuor91.presentation.PostsPresenter
import javax.inject.Inject

class PostsActivity : BaseActivity(), PostsPresenter.View {
    @Inject
    lateinit var postsPresenter: PostsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector().inject(this)
        setContentView(R.layout.activity_posts)
    }

    override fun onStart() {
        super.onStart()
        postsPresenter.view = this
        postsPresenter.getRemotePosts()
    }

    override fun dispose() {
        postsPresenter.dispose()
    }

    override fun displayPosts(postsList: List<Post>) {
        Toast.makeText(baseContext, postsList[0].title, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
        TODO()
    }

    override fun hideProgress() {
        TODO()
    }

    override fun onStop() {
        super.onStop()
        dispose()
    }
}
