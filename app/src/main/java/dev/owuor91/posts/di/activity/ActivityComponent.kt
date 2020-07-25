package dev.owuor91.posts.di.activity

import dagger.Subcomponent
import dev.owuor91.posts.PostsActivity
import dev.owuor91.posts.di.adapter.AdapterComponent
import dev.owuor91.posts.di.fragment.FragmentComponent
import dev.owuor91.posts.ui.activities.BaseActivity

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun fragmentBuilder(): FragmentComponent.Builder

    fun adapterBuilder(): AdapterComponent.Builder

    fun baseInject(baseActivity: BaseActivity)
    fun inject(postsActivity: PostsActivity)

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(activityModule: ActivityModule): Builder

        fun build(): ActivityComponent
    }
}
