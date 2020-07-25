package dev.owuor91.posts.ui.activities

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.owuor91.posts.MyApplication
import dev.owuor91.posts.di.activity.ActivityComponent

abstract class BaseActivity : AppCompatActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
    super.onCreate(savedInstanceState, persistentState)
    injector().baseInject(this)
  }
  
  fun injector(): ActivityComponent {
    return (applicationContext as MyApplication).getActivityInjector(this)
  }
  
  fun handleError(throwable: Throwable) {
    Toast.makeText(baseContext, throwable.message, Toast.LENGTH_LONG).show()
  }
  
  override fun onStart() {
    super.onStart()
  }
  
  override fun onStop() {
    super.onStop()
    dispose()
  }
  
  abstract fun dispose()
}