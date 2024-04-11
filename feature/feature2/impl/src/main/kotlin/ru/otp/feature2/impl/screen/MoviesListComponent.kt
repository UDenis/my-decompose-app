package ru.otp.feature2.impl.screen

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.Flow

@Stable
internal interface MoviesListComponent {
    val state: Flow<ViewModel>

    @Immutable
    data class ViewModel(
        val title: String = "",
        val movieList: List<MovieItem> = emptyList(),
    )

    @Immutable
    data class MovieItem(
        val id: String,
        val name: String,
    )
}