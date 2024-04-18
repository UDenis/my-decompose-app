package ru.otp.app

import android.app.Application
import android.content.pm.PackageManager
import android.util.Log

class AppDelegate(
    private val app: Application
) {
    lateinit var appDI: AppDI
        private set

    fun onCreate() {

        val componentSet = getLinkerClassNameListFromMeta().map { Class.forName(it) }
        Log.d("DDD", "${componentSet}")

        appDI = AppDI(componentSet)
    }

    private fun getLinkerClassNameListFromMeta(): List<String> {
        val appInfo = app.packageManager.getApplicationInfo(
            app.packageName,
            PackageManager.GET_META_DATA
        )
        val metadata = appInfo.metaData
        // Чтобы вызвать unparcel
        metadata.getString("")
        val metadataMap = metadata.keySet().map { it to metadata.get(it) }.toMap()
        return metadataMap.filterValues { it == "dicomponent" }.keys.toList()
    }
}

interface AppDelegateOwner {
    val appDelegate: AppDelegate
}
