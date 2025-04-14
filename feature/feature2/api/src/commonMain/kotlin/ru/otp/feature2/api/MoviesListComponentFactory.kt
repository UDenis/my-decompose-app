package ru.otp.feature2.api

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.feature1.api.repository.IFeature1Repository

fun interface MoviesListComponentFactory {
    operator fun invoke(
        componentContext: ComponentContext,
        deps: Feature2DIModuleDeps,
    ): DecomposeComponent
}

interface Feature2DIModuleDeps {
    val feature1Repository: IFeature1Repository
}
