package dev.owuor91.presentation

interface BasePresenter {
  fun dispose()
  
  interface View{
    fun handleError(throwable: Throwable)
    
    fun showProgress()
    
    fun hideProgress()
  }
}