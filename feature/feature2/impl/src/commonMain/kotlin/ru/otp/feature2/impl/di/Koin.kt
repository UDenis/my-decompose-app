package ru.otp.feature2.impl.di

import com.arkivanov.decompose.ComponentContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.feature2.api.Feature2DIModuleDeps
import ru.otp.feature2.api.MoviesListComponentFactory
import ru.otp.feature2.impl.repository.MovieRepository
import ru.otp.feature2.impl.screen.MoviesListComponentContext
import ru.otp.feature2.impl.screen.MoviesListComponentImpl

fun feature2DIModule(deps: Feature2DIModuleDeps) = module {
    singleOf(::MovieRepository)
    factory {
        deps.feature1Repository
    }
}

class MoviesListComponentFactoryImp : MoviesListComponentFactory {
    override fun invoke(
        componentContext: ComponentContext,
        deps: Feature2DIModuleDeps
    ): DecomposeComponent {
        return MoviesListComponentImpl(
            componentContext = MoviesListComponentContext(componentContext),
            deps = deps,
        )
    }
}