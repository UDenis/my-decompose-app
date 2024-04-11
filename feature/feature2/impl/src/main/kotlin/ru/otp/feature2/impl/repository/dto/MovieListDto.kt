package ru.otp.feature2.impl.repository.dto

import kotlinx.serialization.Serializable
import ru.otp.feature2.impl.model.MovieList

@Serializable
internal class MovieListDto(
    val docs: List<MovieDto>,
    val total: Int,
    val limit: Int,
    val page: Int,
    val pages: Int,
)

internal fun MovieListDto.asModel() = MovieList(
    docs.map { it.asModel() }
)