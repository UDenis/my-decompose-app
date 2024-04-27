package ru.otp.app

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.DIComponentHolder
import ru.otp.feature1.api.di.Feature1DI
import ru.otp.feature1.impl.di.Feature1DIImpl
import ru.otp.feature2.api.di.Feature2DI
import ru.otp.feature2.impl.di.Feature2DIImpl

class AppDI() : IAppDI {
    private val feature1: DIComponentHolder<Feature1DI> = DIComponentHolder() {
        Feature1DIImpl(
            feature2DI = { feature2.get(it) }
        )
    }

    private val feature2: DIComponentHolder<Feature2DI> = DIComponentHolder() {
        Feature2DIImpl(
            feature1DI = { feature1.get(it) }
        )
    }

    override fun homeComponentFactory(componentContext: ComponentContext): DecomposeComponent {
        return feature1.get(componentContext).homeComponentFactory(componentContext)
    }
}

interface IAppDI {
    fun homeComponentFactory(componentContext: ComponentContext): DecomposeComponent
}

