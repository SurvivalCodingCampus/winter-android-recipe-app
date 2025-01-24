package com.surivalcoding.composerecipeapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppApplication: Application() {

}

// Koin 사용
//class AppApplication: Application() {
//
//    override fun onCreate() {
//        super.onCreate()
//
//        startKoin{
//            androidLogger()
//            androidContext(this@AppApplication)
//
//            modules(
//                appModule,
//                dataSourceModule,
//                repositoryModule
//            )
//        }
//    }
//}