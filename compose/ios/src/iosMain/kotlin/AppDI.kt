package ru.otp.app.di

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.DIComponentHolder
import ru.otp.feature1.api.di.Feature1DI
import ru.otp.feature1.impl.di.Feature1DIImpl
import ru.otp.feature2.api.di.Feature2DI
import ru.otp.feature2.impl.di.Feature2DIImpl

class AppDI() {
    private val feature2DI: DIComponentHolder<Feature2DI> = DIComponentHolder {
        Feature2DIImpl(
            feature1DI = feature1DI
        )
    }

    private val feature1DI: DIComponentHolder<Feature1DI> = DIComponentHolder {
        Feature1DIImpl(
            feature2DI = feature2DI
        )
    }

    fun homeComponentFactory(componentContext: ComponentContext): DecomposeComponent = feature1DI
        .get(componentContext)
        .homeComponentFactory(componentContext)
}
