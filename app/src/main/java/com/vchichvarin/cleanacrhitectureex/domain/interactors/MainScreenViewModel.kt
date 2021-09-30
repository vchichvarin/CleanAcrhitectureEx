package com.vchichvarin.cleanacrhitectureex.domain.interactors

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vchichvarin.cleanacrhitectureex.data.interfaces.LoadRepository
import com.vchichvarin.cleanacrhitectureex.domain.models.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val loadRepository: LoadRepository
) : ViewModel() {

    val loadedInfo = MutableLiveData<Int>()

    fun loadSomeInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            loadRepository.loadSomeInfo()
                .catch { it.printStackTrace() }
                .collect {
                    when (it) {
                        is State.Loading -> {

                        }
                        is State.SuccessLoadInfo -> {
                            loadedInfo.postValue(it.info)
                        }
                    }
                }
        }
    }

}