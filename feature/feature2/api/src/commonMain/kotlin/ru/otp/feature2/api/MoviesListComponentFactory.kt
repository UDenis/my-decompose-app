package ru.otp.feature2.api

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent

fun interface MoviesListComponentFactory {
    operator fun invoke(componentContext: ComponentContext): DecomposeComponent
}