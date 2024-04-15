package ru.otp.android

import android.app.Application
import ru.otp.app.AppDelegate
import ru.otp.app.AppDelegateOwner

class App : Application(), AppDelegateOwner {
    override lateinit var appDelegate: AppDelegate
        private set

    override fun onCreate() {
        super.onCreate()
        appDelegate = AppDelegate(this)
        appDelegate.onCreate()
    }

}
