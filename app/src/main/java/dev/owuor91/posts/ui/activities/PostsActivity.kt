package dev.owuor91.posts.ui.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dev.owuor91.domain.models.Post
import dev.owuor91.posts.R
import dev.owuor91.posts.ui.adapter.PostsRvAdapter
import dev.owuor91.presentation.PostsPresenter
import kotlinx.android.synthetic.main.activity_posts.*
import javax.inject.Inject

class PostsActivity : BaseActivity(), PostsPresenter.View {
    @Inject
    lateinit var postsPresenter: PostsPresenter
    var postsAdapter = PostsRvAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector().inject(this)
        setContentView(R.layout.activity_posts)
    }

    override fun onStart() {
        super.onStart()
        postsPresenter.view = this
        postsPresenter.getRemotePosts()
        rvPosts.layoutManager = LinearLayoutManager(baseContext)
        rvPosts.adapter = postsAdapter
    }

    override fun dispose() {
        postsPresenter.dispose()
    }

    override fun displayPosts(postsList: List<Post>) {
        postsAdapter.data = postsList
        postsAdapter.notifyDataSetChanged()
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
