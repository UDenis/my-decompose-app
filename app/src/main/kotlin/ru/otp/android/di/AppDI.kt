package ru.otp.android.di

import com.arkivanov.essenty.lifecycle.Lifecycle
import ru.otp.core.di.DIComponentProvider
import ru.otp.feature1.impl.di.Feature1DI
import ru.otp.feature2.impl.di.Feature2DI
import ru.otp.core.di.DIComponentHolder

class AppDI() {

    private val feature2DI: DIComponentHolder<Feature2DI> = DIComponentHolder {
        Feature2DI(
            feature1Repository = diComponentProvider {
                feature1DI.get(it).feature1Repository()
            },
        )
    }

    val feature1DI: DIComponentHolder<Feature1DI> = DIComponentHolder {
        Feature1DI(
            moviesListComponent = {
                feature2DI.get(it).moviesListComponentFactory(it)
            },
        )
    }
}

private inline fun <T : Any> diComponentProvider(crossinline callback: (Lifecycle) -> T): DIComponentProvider<T> =
    object : DIComponentProvider<T> {
        override fun get(lifecycle: Lifecycle): T {
            return callback(lifecycle)
        }
    }
