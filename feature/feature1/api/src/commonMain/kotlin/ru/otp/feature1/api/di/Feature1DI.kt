package ru.otp.feature1.api.di

import ru.otp.core.di.DIComponent
import ru.otp.feature1.api.HomeComponentFactory
import ru.otp.feature1.api.repository.IFeature1Repository

abstract class Feature1DI : DIComponent() {

    abstract val homeComponentFactory: HomeComponentFactory

    abstract fun feature1Repository(): IFeature1Repository
}