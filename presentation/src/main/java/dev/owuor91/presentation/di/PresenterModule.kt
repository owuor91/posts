package dev.owuor91.presentation.di

import dagger.Module
import dev.owuor91.data.di.DataModule

@Module(includes = [DataModule::class])
class PresenterModule
