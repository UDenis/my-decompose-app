package ru.otp.feature1.impl.di

import com.arkivanov.decompose.ComponentContext
import me.tatarka.inject.annotations.Inject
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.AppGraph
import ru.otp.core.di.DIComponentProvider
import ru.otp.core.di.SingleInstance
import ru.otp.feature1.api.HomeComponentFactory
import ru.otp.feature1.api.di.Feature1DI
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature1.impl.repository.Feature1RepositoryImpl
import ru.otp.feature1.impl.screen.HomeComponentContext
import ru.otp.feature1.impl.screen.HomeComponentImpl
import ru.otp.feature2.api.MoviesListComponentFactory
import ru.otp.feature2.api.di.Feature2DI
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
@ContributesBinding(AppGraph::class, HomeComponentFactory::class)
class HomeComponentFactoryImpl(
    private val moviesListComponent: MoviesListComponentFactory,
) : HomeComponentFactory {
    override fun invoke(componentContext: ComponentContext): DecomposeComponent {
        return HomeComponentImpl(
            componentContext = HomeComponentContext(componentContext),
            moviesListComponent = moviesListComponent,
        )
    }
}