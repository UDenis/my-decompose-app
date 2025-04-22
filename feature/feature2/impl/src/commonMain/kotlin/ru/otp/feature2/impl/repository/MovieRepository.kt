package ru.otp.feature2.impl.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import me.tatarka.inject.annotations.Inject
import ru.otp.core.di.AppGraph
import ru.otp.feature2.impl.model.MovieList
import ru.otp.feature2.impl.repository.dto.MovieDto
import ru.otp.feature2.impl.repository.dto.MovieListDto
import ru.otp.feature2.impl.repository.dto.asModel
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

//@SingleIn(AppGraph::class)
//@ContributesBinding(AppGraph::class, IMovieRepository::class)
@Inject
class MovieRepository(
    //private val httpClient: HttpClient,
) : IMovieRepository {
    internal suspend fun loadMovieList(): MovieList = withContext(Dispatchers.IO) {
        //val movieListDto: MovieListDto = httpClient.get("/v1.4/movie").body()
        val movieListDto: MovieListDto = MovieListDto(
            docs = (1..15).map {
                MovieDto(
                    id = it.toString(),
                    name = "Movie $it"
                )
            },
            total = 100,
            limit = 10,
            page = 0,
            pages = 1,
        )
        movieListDto.asModel()
    }
}

interface IMovieRepository