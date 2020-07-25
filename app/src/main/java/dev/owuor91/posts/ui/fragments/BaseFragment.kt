package dev.owuor91.posts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.owuor91.posts.di.activity.ActivityComponent
import dev.owuor91.posts.di.fragment.FragmentComponent
import dev.owuor91.posts.di.fragment.FragmentModule
import dev.owuor91.posts.ui.activities.BaseActivity

abstract class BaseFragment : androidx.fragment.app.Fragment() {
  
  val layoutId: Int
    get() = NO_LAYOUT
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    injector().baseInject(this)
  }
  
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return if (layoutId != NO_LAYOUT) {
      inflater.inflate(layoutId, container, false)
    } else {
      super.onCreateView(inflater, container, savedInstanceState)
    }
  }
  
  fun handleError(throwable: Throwable) {
    Toast.makeText(context, throwable.message, Toast.LENGTH_LONG)
        .show()
  }
  
  protected fun injector(): FragmentComponent {
    return activityInjector().fragmentBuilder()
        .fragmentModule(
            FragmentModule(
                this
            )
        )
        .build()
  }
  
  protected fun activityInjector(): ActivityComponent {
    return (activity as BaseActivity).injector()
  }
  
  override fun onDestroy() {
    super.onDestroy()
    dispose()
  }
  
  abstract fun dispose()
  
  companion object {
    private val NO_LAYOUT = -1
  }
}
