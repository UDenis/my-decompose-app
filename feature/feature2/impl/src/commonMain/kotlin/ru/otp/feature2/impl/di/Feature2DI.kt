package ru.otp.feature2.impl.di

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.DIComponentProvider
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature2.api.MoviesListComponentFactory
import ru.otp.feature2.impl.repository.MovieRepository
import ru.otp.feature2.impl.screen.MoviesListComponentContext
import ru.otp.feature2.impl.screen.MoviesListComponentImpl

class Feature2DI(
    internal val feature1Repository: DIComponentProvider<IFeature1Repository>,
) {

    internal fun movieRepository(): MovieRepository {
        return MovieRepository()
    }

    val moviesListComponentFactory = object : MoviesListComponentFactory {
        override fun invoke(componentContext: ComponentContext): DecomposeComponent {
            return MoviesListComponentImpl(
                componentContext = MoviesListComponentContext(
                    componentContext = componentContext,
                ),
                feature2DI = this@Feature2DI,
            )
        }
    }
}