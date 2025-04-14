package ru.otp.feature2.impl.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.map
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.decompose.getOrCreateContainerHost
import ru.otp.core.di.ComponentKoinContext
import ru.otp.feature2.api.Feature2DIModuleDeps
import ru.otp.feature2.impl.di.feature2DIModule
import ru.otp.feature2.impl.screen.compose.MoviesListContent
import ru.otp.feature2.impl.screen.store.MovieListContainerHost

internal class MoviesListComponentImpl(
    deps: Feature2DIModuleDeps,
    componentContext: MoviesListComponentContext,
) : DecomposeComponent(), MoviesListComponent,
    ComponentContext by componentContext {

    private val koinScope = instanceKeeper
        .getOrCreate {
            ComponentKoinContext()
        }.getOrCreateKoinScope(
            listOf(
                feature2DIModule(deps)
            )
        )

    private val container = getOrCreateContainerHost {
        MovieListContainerHost(
            scope = scope,
            movieRepository = koinScope.get(),
            feature1Repository = koinScope.get(),
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