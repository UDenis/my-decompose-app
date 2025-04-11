package ru.otp.app

import android.app.Application
import ru.otp.core.di.ComponentKoinContext

class AppDelegate(
    private val app: Application
) {
    lateinit var appDI: IAppDI
        private set

    lateinit var componentKoinContext: ComponentKoinContext

    fun onCreate() {
        appDI = AppDI<Any>()
        componentKoinContext = ComponentKoinContext()
    }
}

interface AppDelegateOwner {
    val appDelegate: AppDelegate
}
