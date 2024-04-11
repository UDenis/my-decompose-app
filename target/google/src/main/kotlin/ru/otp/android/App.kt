package ru.otp.android

import android.app.Application
import ru.otp.app.AppDelegate

class App : Application() {

    private lateinit var appDelegate: AppDelegate

    override fun onCreate() {
        super.onCreate()
        appDelegate = AppDelegate(this)
        appDelegate.onCreate()
    }
}
