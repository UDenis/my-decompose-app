package ru.otp.feature1.impl.screen.store

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

internal class HomeContainerHost(
    coroutineScope: CoroutineScope,
) : ContainerHost<HomeState, Effect> {
    override val container = coroutineScope.container<HomeState, Effect>(HomeState())

    val stateFlow = container.stateFlow
    val sideEffectFlow = container.sideEffectFlow

    init {
        intent {
            delay(3000)
            reduce {
                state.copy(
                    title = "Welcome",
                    isLoading = false,
                )
            }
        }
    }

    fun onOpenMoviesListClicked() = intent {
        postSideEffect(Effect.Navigation.MoviesList)
    }
}