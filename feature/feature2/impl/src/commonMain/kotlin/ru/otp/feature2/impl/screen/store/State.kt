package ru.otp.feature2.impl.screen.store

import ru.otp.feature2.impl.model.MovieList

internal data class State(
    val title: String = "",
    val movieList: MovieList = MovieList.EMPTY
)
