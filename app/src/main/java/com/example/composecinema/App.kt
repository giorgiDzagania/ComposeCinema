package com.example.composecinema

import android.app.Application
import com.example.composecinema.di.fireBaseModule
import com.example.composecinema.di.repositoryModule
import com.example.composecinema.di.useCaseViewModel
import com.example.composecinema.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                fireBaseModule,
                repositoryModule,
                useCaseViewModel,
                viewModelModule,
            )
        }
    }
}
