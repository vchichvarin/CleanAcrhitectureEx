package com.vchichvarin.cleanacrhitectureex.data.impl

import com.vchichvarin.cleanacrhitectureex.data.interfaces.LoadRepository
import com.vchichvarin.cleanacrhitectureex.domain.models.State
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoadRepositoryImpl @Inject constructor(

) : LoadRepository {

    override fun loadSomeInfo() = flow {
        emit(State.Loading)
        delay(3000)
        emit(State.SuccessLoadInfo(1))
    }
}