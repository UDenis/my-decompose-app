package ru.otp.feature2.impl.model

internal class MovieList(
    items: List<Movie>
) : List<Movie> by items {
    companion object {
        val EMPTY = MovieList(emptyList())
    }
}