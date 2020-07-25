package dev.owuor91.posts.di.fragment

import dagger.Subcomponent
import dev.owuor91.posts.ui.fragments.BaseFragment

@Subcomponent(modules = [FragmentModule::class])
interface FragmentComponent {

  fun baseInject(baseFragment: BaseFragment)
  @Subcomponent.Builder
  interface Builder {
    fun fragmentModule(fragmentModule: FragmentModule): Builder
    fun build(): FragmentComponent
  }
}
