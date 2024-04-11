package ru.otp.android

import android.app.Application

class App : Application() {

    private lateinit var appDelegate: AppDelegate

    override fun onCreate() {
        super.onCreate()
        appDelegate = AppDelegate(this)
        appDelegate.onCreate()
    }
}
