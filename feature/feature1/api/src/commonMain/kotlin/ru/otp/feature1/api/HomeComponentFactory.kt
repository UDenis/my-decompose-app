package ru.otp.feature1.api

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent

fun interface HomeComponentFactory {
    operator fun invoke(componentContext: ComponentContext): DecomposeComponent
}