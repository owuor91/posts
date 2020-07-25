package dev.owuor91.data.di

import dagger.Module

@Module(includes = [ApiModule::class, DatabaseModule::class, RepositoryModule::class])
class DataModule
