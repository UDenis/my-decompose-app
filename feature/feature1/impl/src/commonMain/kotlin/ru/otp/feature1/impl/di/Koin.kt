package ru.otp.feature1.impl.di

import com.arkivanov.decompose.ComponentContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.feature1.api.HomeComponentFactory
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature1.impl.repository.Feature1RepositoryImpl
import ru.otp.feature1.impl.screen.HomeComponentContext
import ru.otp.feature1.impl.screen.HomeComponentImpl
import ru.otp.feature2.api.Feature2DIModuleDeps
import ru.otp.feature2.api.MoviesListComponentFactory

val feature1DIModule = module {
    singleOf(::Feature1RepositoryImpl).bind<IFeature1Repository>()
    factory {
        object : Feature2DIModuleDeps {
            override val feature1Repository: IFeature1Repository = get()
        }
    }.bind<Feature2DIModuleDeps>()
}

class HomeComponentFactoryImpl(
    private val moviesListComponent: MoviesListComponentFactory,
) : HomeComponentFactory {
    override fun invoke(componentContext: ComponentContext): DecomposeComponent {
        return HomeComponentImpl(
            componentContext = HomeComponentContext(componentContext),
            moviesListComponent = moviesListComponent
        )
    }
}