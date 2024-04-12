package ru.otp.feature2.impl.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.map
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.feature2.impl.screen.compose.MoviesListContent
import ru.otp.feature2.impl.screen.store.MovieListContainerHost
import kotlin.coroutines.CoroutineContext

internal class MoviesListComponentImpl(
    componentContext: MoviesListComponentContext,
    mainContext: CoroutineContext = Dispatchers.Main.immediate,
) : DecomposeComponent(), MoviesListComponent,
    ComponentContext by componentContext {
    private val scope = coroutineScope(mainContext + SupervisorJob())

    private val container = MovieListContainerHost(
        scope = scope,
        movieRepository = componentContext.feature2DI.movieRepository(),
        feature1Repository = componentContext.feature2DI.feature1Repository.get(this),
    )
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