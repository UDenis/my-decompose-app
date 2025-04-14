package ru.otp.app

import android.app.Application

class AppDelegate(
    private val app: Application
) {
    lateinit var appDI: AppDI
        private set

    fun onCreate() {
        appDI = AppDI()
    }
}

interface AppDelegateOwner {
    val appDelegate: AppDelegate
}
