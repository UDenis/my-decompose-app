package ru.otp.feature2.impl.screen.store

import io.github.aakira.napier.Napier
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature2.impl.repository.MovieRepository

private const val TAG = "MovieListContainer"

/**
 * @see ru.my.app.movie_list.compose.MoviesListContent
 */
internal class MovieListContainerHost(
    scope: CoroutineScope,
    initialState: State = State(),
    private val movieRepository: MovieRepository,
    private val feature1Repository: IFeature1Repository,
) : ContainerHost<State, Effect> {

    override val container = scope.container<State, Effect>(initialState)

    val stateFlow = container.stateFlow
    val sideEffectFlow = container.sideEffectFlow

    init {
        bootstrap()
    }

    private fun bootstrap() = intent {
        try {
            val movieList = movieRepository.loadMovieList()
            reduce {
                state.copy(
                    title = feature1Repository.getSome(),
                    movieList = movieList
                )
            }
        } catch (ignore: CancellationException) {
            throw ignore
        } catch (ex: Throwable) {
            Napier.w(ex, TAG) {
                "Ошибка загрузки списка фильмов"
            }
        }
    }
}