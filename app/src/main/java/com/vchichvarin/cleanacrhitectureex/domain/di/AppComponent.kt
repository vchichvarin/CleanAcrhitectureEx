package com.vchichvarin.cleanacrhitectureex.domain.di

import com.vchichvarin.cleanacrhitectureex.domain.di.modules.DispatchersModule
import com.vchichvarin.cleanacrhitectureex.domain.di.modules.RepositoriesModule
import com.vchichvarin.cleanacrhitectureex.domain.di.modules.ViewModelModule
import com.vchichvarin.cleanacrhitectureex.ui.main.MainScreenFlowFragment
import com.vchichvarin.cleanacrhitectureex.ui.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DispatchersModule::class,
    RepositoriesModule::class,
    ViewModelModule::class])
interface AppComponent {

    fun inject(activity: SplashActivity)

    fun inject(fragment: MainScreenFlowFragment)

}