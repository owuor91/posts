package dev.owuor91.data.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dev.owuor91.data.BuildConfig
import dev.owuor91.data.api.PostsApi
import dev.owuor91.domain.di.DIConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.HEADERS
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class ApiModule {

  @Provides @Named(DIConstants.DEFAULT) fun provideDefaultOkHttpClient(): OkHttpClient {
    var httpLoggingInterceptor = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
      httpLoggingInterceptor.level = HEADERS
      httpLoggingInterceptor.level = BODY
    }
    return OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
      .writeTimeout(1, TimeUnit.MINUTES)
      .readTimeout(2, TimeUnit.MINUTES)
      .retryOnConnectionFailure(true)
      .addInterceptor(httpLoggingInterceptor)
      .build()
  }

  @Provides
  @Named(DIConstants.DEFAULT)
  fun provideDefaultRetrofit(gson: Gson, @Named(DIConstants.DEFAULT) okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .client(okHttpClient)
      .build()
  }

  @Provides fun providePostsApi(@Named(DIConstants.DEFAULT) retrofit: Retrofit): PostsApi{
    return retrofit.create(PostsApi::class.java)
  }
}
