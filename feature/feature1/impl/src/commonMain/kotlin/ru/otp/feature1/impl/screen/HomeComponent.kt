package ru.otp.feature1.impl.screen

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.StateFlow
import ru.otp.core.decompose.DecomposeComponent

internal interface HomeComponent{
    val state: StateFlow<ViewModel>

    val childStack: Value<ChildStack<RouteConfiguration, DecomposeComponent>>

    fun onOpenMoviesListClicked()

    data class ViewModel(
        val title: String = "Loading...",
        val buttonIsEnabled: Boolean = true
    )
}