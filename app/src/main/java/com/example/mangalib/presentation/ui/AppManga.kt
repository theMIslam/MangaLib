package com.example.mangalib.presentation.ui

import android.app.Application
import com.example.mangalib.di.appModule
import com.example.mangalib.di.dataModule
import com.example.mangalib.di.domainModule
import com.example.mangalib.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppManga : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppManga)
            modules(listOf(appModule, dataModule, domainModule, networkModule))
        }
    }

}