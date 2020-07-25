package dev.owuor91.posts

import android.os.Bundle
import dev.owuor91.posts.ui.activities.BaseActivity

class MainActivity : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
  
  override fun dispose() {
    //
  }
}
