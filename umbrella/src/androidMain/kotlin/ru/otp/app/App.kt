package ru.otp.app

import android.app.Application

class App : Application(), AppDIOwner {
    override lateinit var androidAppDI: AppDI
        private set

    override fun onCreate() {
        super.onCreate()
        androidAppDI = AndroidAppDI::class.create()
    }
}
