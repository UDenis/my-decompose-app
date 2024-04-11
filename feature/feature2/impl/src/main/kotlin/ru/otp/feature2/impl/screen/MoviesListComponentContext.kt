package ru.otp.feature2.impl.screen

import com.arkivanov.decompose.ComponentContext
import ru.otp.feature2.impl.di.Feature2DI

internal class MoviesListComponentContext(
    componentContext: ComponentContext,
    val feature2DI: Feature2DI,
) : ComponentContext by componentContext {

}
