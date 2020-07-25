package dev.owuor91.posts.di.app

import dagger.Component
import dev.owuor91.posts.MyApplication
import dev.owuor91.posts.di.activity.ActivityComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
  fun activityComponentBuilder(): ActivityComponent.Builder

  fun inject(myApplication: MyApplication)
}
