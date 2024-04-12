package ru.otp.feature2.impl.screen.compose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import ru.otp.feature2.impl.screen.MoviesListComponent

@Composable
internal fun MoviesListContent(
    moviesListComponent: MoviesListComponent
) {
    val vm = moviesListComponent.state.collectAsState(MoviesListComponent.ViewModel())

    LazyColumn {
        val vModel = vm.value
        val items = vModel.movieList

        item {
            Row {
                Text(
                    text = vModel.title,
                )
            }
        }

        items(
            count = items.size,
            key = { i -> items[i].id },
        ) { i ->
            Row {
                Text(
                    text = items[i].name
                )
            }
        }
    }


}