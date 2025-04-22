package ru.otp.feature2.impl.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.map
import me.tatarka.inject.annotations.Assisted
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.decompose.getOrCreateContainerHost
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature2.impl.repository.MovieRepository
import ru.otp.feature2.impl.screen.compose.MoviesListContent
import ru.otp.feature2.impl.screen.store.MovieListContainerHost

internal class MoviesListComponentImpl(
    @Assisted componentContext: ComponentContext,
    movieRepository: Lazy<MovieRepository>,
    feature1Repository: Lazy<IFeature1Repository>,
) : DecomposeComponent(), MoviesListComponent,
    ComponentContext by componentContext {

    private val container = getOrCreateContainerHost {
        MovieListContainerHost(
            scope = scope,
            movieRepository = movieRepository.value,
            feature1Repository = feature1Repository.value,
        )
    }

    override val state = container.stateFlow.map {
        MoviesListComponent.ViewModel(
            title = it.title,
            it.movieList.map {
                MoviesListComponent.MovieItem(
                    id = it.id,
                    name = it.name,
                )
            }
        )
    }

    @Composable
    override fun Render() {
        MoviesListContent(this)
    }
}