package dev.owuor91.presentation

import dev.owuor91.data.util.RxUtil
import dev.owuor91.domain.di.DIConstants
import dev.owuor91.domain.models.Post
import dev.owuor91.domain.repository.PostsRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class PostsPresenter @Inject constructor() : BasePresenter {
    private var compositeDisposable: CompositeDisposable? = null
    lateinit var view: View

    @Inject
    @field:Named(DIConstants.API)
    lateinit var postsApiRepository: PostsRepository

    @Inject
    @field:Named(DIConstants.DB)
    lateinit var postsDbRepository: PostsRepository

    fun getRemotePosts() {
        compositeDisposable = RxUtil.initDisposables(compositeDisposable)

        var disposable = postsApiRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .flatMapPublisher { posts -> Flowable.fromIterable(posts) }
            .flatMapSingle { post -> postsDbRepository.savePost(post) }
            .toList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::displayPosts, view::handleError)

        compositeDisposable?.add(disposable)
    }

    fun getPosts() {
        compositeDisposable = RxUtil.initDisposables(compositeDisposable)

        var disposable = postsDbRepository.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::displayPosts, view::handleError)

        compositeDisposable?.add(disposable)
    }

    override fun dispose() {
        RxUtil.dispose(compositeDisposable)
    }

    interface View : BasePresenter.View {
        fun displayPosts(postsList: List<Post>)
    }
}