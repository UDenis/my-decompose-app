package ru.otp.feature2.impl.di

import com.arkivanov.decompose.ComponentContext
import me.tatarka.inject.annotations.Inject
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.AppGraph
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature2.api.MoviesListComponentFactory
import ru.otp.feature2.impl.repository.MovieRepository
import ru.otp.feature2.impl.screen.MoviesListComponentImpl
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding


@Inject
@ContributesBinding(AppGraph::class, MoviesListComponentFactory::class)
class MoviesListComponentFactoryImpl(
    private val movieRepository: Lazy<MovieRepository>,
    private val feature1Repository: Lazy<IFeature1Repository>,
) : MoviesListComponentFactory {
    override fun invoke(componentContext: ComponentContext): DecomposeComponent {
        return MoviesListComponentImpl(
            componentContext = componentContext,
            movieRepository = movieRepository,
            feature1Repository = feature1Repository,
        )
    }
}