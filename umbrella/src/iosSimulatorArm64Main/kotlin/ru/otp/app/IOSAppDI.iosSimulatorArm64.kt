package ru.otp.app

actual fun getIOSAppComponent(): IOSAppDI {
    return IOSAppDI::class.create()
}