package dev.owuor91.posts.di.activity

import android.content.Context
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import dev.owuor91.domain.di.DIConstants
import dev.owuor91.posts.di.adapter.AdapterComponent
import dev.owuor91.posts.ui.activities.BaseActivity
import dev.owuor91.presentation.di.PresenterModule
import javax.inject.Named

@Module(includes = [PresenterModule::class], subcomponents = [AdapterComponent::class])
class ActivityModule(private val baseActivity: BaseActivity) {

  @Provides @Named(DIConstants.ACTIVITY) fun provideActivityContext(): Context {
    return baseActivity
  }

  @Provides fun provideActivity(): BaseActivity {
    return baseActivity
  }

  @Provides fun provideLayoutInflater(@Named(DIConstants.ACTIVITY) context: Context): LayoutInflater {
    return LayoutInflater.from(context)
  }

  @Provides fun provideFragmentManager(activity: BaseActivity): androidx.fragment.app.FragmentManager {
    return activity.getSupportFragmentManager()
  }
}
