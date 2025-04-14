package ru.otp.app.di

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.feature1.impl.di.HomeComponentFactoryImpl
import ru.otp.feature2.impl.di.MoviesListComponentFactoryImp

class AppDI() {
    fun homeComponentFactory(componentContext: ComponentContext): DecomposeComponent {
        return HomeComponentFactoryImpl(
            moviesListComponent = MoviesListComponentFactoryImp(),
        ).invoke(componentContext)
    }
}
