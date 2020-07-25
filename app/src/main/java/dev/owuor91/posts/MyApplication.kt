package dev.owuor91.posts

import android.app.Application

import com.facebook.stetho.Stetho
import dev.owuor91.posts.di.activity.ActivityComponent
import dev.owuor91.posts.di.activity.ActivityModule
import dev.owuor91.posts.di.app.AndroidModule
import dev.owuor91.posts.di.app.ApplicationComponent
import dev.owuor91.posts.di.app.ApplicationModule
import dev.owuor91.posts.di.app.DaggerApplicationComponent
import dev.owuor91.posts.ui.activities.BaseActivity

class MyApplication : Application() {
  private var applicationComponent: ApplicationComponent? = null

  override fun onCreate() {
    super.onCreate()
    applicationComponent = DaggerApplicationComponent.builder()
      .applicationModule(
          ApplicationModule(
              this
          )
      )
      .androidModule(AndroidModule(this))
      .build()
    applicationComponent!!.inject(this)

    Stetho.initializeWithDefaults(this)
  }

  fun getActivityInjector(baseActivity: BaseActivity): ActivityComponent {
    return applicationComponent!!.activityComponentBuilder().activityModule(
        ActivityModule(
            baseActivity
        )
    ).build()
  }
}
