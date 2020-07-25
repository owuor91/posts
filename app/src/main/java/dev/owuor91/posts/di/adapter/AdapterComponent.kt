package dev.owuor91.posts.di.adapter

import dagger.Subcomponent

@Subcomponent(modules = [AdapterModule::class])
interface AdapterComponent {

  @Subcomponent.Builder
  interface Builder {
    fun adapterModule(adapterModule: AdapterModule): Builder

    fun build(): AdapterComponent
  }
}
