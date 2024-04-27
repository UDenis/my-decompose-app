package ru.otp.feature1.impl.di

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.DIComponentProvider
import ru.otp.core.di.SingleInstance
import ru.otp.feature1.api.HomeComponentFactory
import ru.otp.feature1.api.di.Feature1DI
import ru.otp.feature1.api.repository.IFeature1Repository
import ru.otp.feature1.impl.repository.Feature1RepositoryImpl
import ru.otp.feature1.impl.screen.HomeComponentContext
import ru.otp.feature1.impl.screen.HomeComponentImpl
import ru.otp.feature2.api.di.Feature2DI

//@ComponentDeps(
//    deps = [Feature2DI::class]
//)
class Feature1DIImpl(
    private val feature2DI: DIComponentProvider<Feature2DI>,
) : Feature1DI() {

    private val feature1Repository =
        SingleInstance<IFeature1Repository> { Feature1RepositoryImpl() }

    override val homeComponentFactory = object : HomeComponentFactory {
        override fun invoke(componentContext: ComponentContext): DecomposeComponent {
            return HomeComponentImpl(
                componentContext = HomeComponentContext(componentContext),
                moviesListComponent = feature2DI.get(componentContext).moviesListComponentFactory,
            )
        }

    }

    override fun feature1Repository() = feature1Repository.get()
}