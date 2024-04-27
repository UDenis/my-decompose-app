package ru.otp.feature2.impl.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.map
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.decompose.getOrCreateContainerHost
import ru.otp.feature2.impl.di.Feature2DIImpl
import ru.otp.feature2.impl.screen.compose.MoviesListContent
import ru.otp.feature2.impl.screen.store.MovieListContainerHost

internal class MoviesListComponentImpl(
    componentContext: MoviesListComponentContext,
    private val feature2DI: Feature2DIImpl,
) : DecomposeComponent(), MoviesListComponent,
    ComponentContext by componentContext {

    private val container = getOrCreateContainerHost {
        MovieListContainerHost(
            scope = scope,
            movieRepository = feature2DI.movieRepository(),
            //feature1Repository = feature2DI.feature1Repository.get(this),
            feature1Repository = feature2DI.feature1Repository(this),
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