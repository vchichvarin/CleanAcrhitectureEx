package com.vchichvarin.cleanacrhitectureex.domain.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@Module
class DispatchersModule {
    @Provides
    @Named("IO")
    fun provideDispatcherIO() = Dispatchers.IO

}