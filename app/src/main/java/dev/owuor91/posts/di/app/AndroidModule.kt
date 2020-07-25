package dev.owuor91.posts.di.app

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dev.owuor91.domain.di.DIConstants
import javax.inject.Named

@Module
class AndroidModule(private val context: Context) {

  @Provides fun provideSharedPreferences(@Named(DIConstants.APP) context: Context): SharedPreferences {
    return context.getSharedPreferences("app_name_sharedprefs", Context.MODE_PRIVATE)
  }

  @Provides fun provideResources(@Named(DIConstants.APP) context: Context): Resources {
    return context.resources
  }
}
