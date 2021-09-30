package com.vchichvarin.cleanacrhitectureex.domain.interactors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(

) : ViewModel() {

    val fragmentState = MutableLiveData<Int>()

    fun replaceFragment(fragment: Int) {
        fragmentState.postValue(fragment)
    }

}