package ru.otp.app

import ru.otp.feature1.api.HomeComponentFactory

interface AppDI {
    val homeComponentFactory: HomeComponentFactory
}

interface AppDIOwner {
    val androidAppDI: AppDI
}

