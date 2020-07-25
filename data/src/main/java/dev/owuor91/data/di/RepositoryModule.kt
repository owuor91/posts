package dev.owuor91.data.di

import dagger.Module
import dagger.Provides
import dev.owuor91.data.api.PostsApi
import dev.owuor91.data.local.PostsDao
import dev.owuor91.data.repository.PostsApiRepository
import dev.owuor91.data.repository.PostsDbRepository
import dev.owuor91.domain.di.DIConstants
import dev.owuor91.domain.repository.PostsRepository
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    @Named(DIConstants.API)
    fun providePostsApiRepository(postsApi: PostsApi): PostsRepository {
        return PostsApiRepository(postsApi)
    }

    @Provides
    @Named(DIConstants.DB)
    fun providePostsDbRepository(postsDao: PostsDao): PostsRepository {
        return PostsDbRepository(postsDao)
    }
}
