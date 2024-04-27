package ru.otp.feature2.impl.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.DIComponentProvider
import ru.otp.core.di.SingleInstance
import ru.otp.feature1.api.di.Feature1DI
import ru.otp.feature2.api.MoviesListComponentFactory
import ru.otp.feature2.api.di.Feature2DI
import ru.otp.feature2.impl.repository.MovieRepository
import ru.otp.feature2.impl.screen.MoviesListComponentContext
import ru.otp.feature2.impl.screen.MoviesListComponentImpl

//@ComponentDeps(
//    deps = [Feature1DI::class]
//)
class Feature2DIImpl(
    internal val feature1DI: DIComponentProvider<Feature1DI>,
) : Feature2DI() {

    private val movieRepository = SingleInstance() {
        MovieRepository()
    }

    internal fun movieRepository() = movieRepository.get()

    internal fun feature1Repository(lifecycle: LifecycleOwner) =
        feature1DI.get(lifecycle).feature1Repository()

    override val moviesListComponentFactory = object : MoviesListComponentFactory {
        override fun invoke(componentContext: ComponentContext): DecomposeComponent {
            return MoviesListComponentImpl(
                componentContext = MoviesListComponentContext(
                    componentContext = componentContext,
                ),
                feature2DI = this@Feature2DIImpl,
            )
        }
    }
}