package com.surivalcoding.composerecipeapp.util

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.hilt.android.HiltAndroidApp

/*
* Hilt를 사용하는 모든 앱은 @HiltAndroidApp으로 주석이 지정된 Application 클래스를 포함해야 한다.
* */
@HiltAndroidApp
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initLogger()
    }

    private fun initLogger() {
        // Logger 설정
        val strategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .methodCount(5)
            .tag("LOG_RESULT")
            .build()
        Logger.clearLogAdapters()
        Logger.addLogAdapter(AndroidLogAdapter(strategy))
    }
}



