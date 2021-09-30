package com.vchichvarin.cleanacrhitectureex.domain.models

sealed class State {

    data class SuccessLoadInfo(val info: Int) : State()
    object Error : State()
    object Loading : State()

}