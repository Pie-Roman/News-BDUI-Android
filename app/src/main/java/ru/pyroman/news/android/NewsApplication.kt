package ru.pyroman.news.android

import android.app.Application
import ru.pyroman.news.common.core.platform.PlatformConfiguration
import ru.pyroman.news.common.umbrella.PlatformSDK
import ru.pyroman.news.common.umbrella.androidUmbrellaModule

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }

    private fun initPlatformSdk() {
        PlatformSDK.initPlatform(
            configuration = PlatformConfiguration(applicationContext),
            platformModule = androidUmbrellaModule,
        )
    }
}