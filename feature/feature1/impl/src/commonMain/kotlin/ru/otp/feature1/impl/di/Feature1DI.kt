package ru.otp.feature1.impl.di

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.feature1.api.HomeComponentFactory
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature1.impl.repository.Feature1RepositoryImpl
import ru.otp.feature1.impl.screen.HomeComponentContext
import ru.otp.feature1.impl.screen.HomeComponentImpl
import ru.otp.feature2.api.MoviesListComponentFactory

class Feature1DI(
    private val moviesListComponent: MoviesListComponentFactory,
) {

    val homeComponentFactory = object : HomeComponentFactory {
        override fun invoke(componentContext: ComponentContext): DecomposeComponent {
            return HomeComponentImpl(
                componentContext = HomeComponentContext(componentContext),
                moviesListComponent = moviesListComponent,
            )
        }

    }

    fun feature1Repository(): IFeature1Repository {
        return Feature1RepositoryImpl()
    }
}