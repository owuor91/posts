package dev.owuor91.data.util

import io.reactivex.disposables.CompositeDisposable

class RxUtil {
  companion object {
    fun initDisposables(compositeDisposable: CompositeDisposable?): CompositeDisposable {
      return if (compositeDisposable != null) {
        if (compositeDisposable.isDisposed) {
          CompositeDisposable()
        } else {
          compositeDisposable
        }
      } else {
        CompositeDisposable()
      }
    }
  
    fun dispose(compositeDisposable: CompositeDisposable?) {
      compositeDisposable?.dispose()
    }
  }
}
