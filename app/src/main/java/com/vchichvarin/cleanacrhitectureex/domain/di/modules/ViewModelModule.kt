package com.vchichvarin.cleanacrhitectureex.domain.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vchichvarin.cleanacrhitectureex.domain.di.factory.ViewModelFactory
import com.vchichvarin.cleanacrhitectureex.domain.interactors.MainScreenViewModel
import com.vchichvarin.cleanacrhitectureex.domain.interactors.SplashViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun splashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun mainViewModel(viewModel: MainScreenViewModel): ViewModel

}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)