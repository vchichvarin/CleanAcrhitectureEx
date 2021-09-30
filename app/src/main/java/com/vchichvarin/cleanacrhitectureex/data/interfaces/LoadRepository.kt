package com.vchichvarin.cleanacrhitectureex.data.interfaces

import com.vchichvarin.cleanacrhitectureex.domain.models.State
import kotlinx.coroutines.flow.Flow

interface LoadRepository {

    fun loadSomeInfo() : Flow<State?>

}