package com.example.mvvmexample

import android.app.Application
import com.example.mvvmexample.di.networkModule
import com.example.mvvmexample.di.repositoryModule
import com.example.mvvmexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            androidFileProperties()

            modules(listOf(viewModelModule, networkModule, repositoryModule))
        }

    }
}