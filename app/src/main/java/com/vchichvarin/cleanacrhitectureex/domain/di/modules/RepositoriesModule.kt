package com.vchichvarin.cleanacrhitectureex.domain.di.modules

import com.vchichvarin.cleanacrhitectureex.data.impl.LoadRepositoryImpl
import com.vchichvarin.cleanacrhitectureex.data.interfaces.LoadRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun loadRepository(loadRepositoryImpl: LoadRepositoryImpl) : LoadRepository

}