package com.vchichvarin.cleanacrhitectureex

import android.app.Application
import com.vchichvarin.cleanacrhitectureex.domain.di.AppComponent
import com.vchichvarin.cleanacrhitectureex.domain.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .build()
    }

    companion object{
        lateinit var appComponent: AppComponent
    }

}