package com.brian.androidmultimodulenavigation

import android.app.Application
import com.brian.androidmultimodulenavigation.di.routeModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(routeModule)
        }
    }
}
