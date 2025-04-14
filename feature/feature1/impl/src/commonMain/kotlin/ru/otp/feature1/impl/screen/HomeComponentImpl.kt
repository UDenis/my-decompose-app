package ru.otp.feature1.impl.screen

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.decompose.getOrCreateContainerHost
import ru.otp.core.di.ComponentKoinContext
import ru.otp.feature1.impl.di.feature1DIModule
import ru.otp.feature1.impl.screen.compose.HomeContent
import ru.otp.feature1.impl.screen.store.HomeContainerHost
import ru.otp.feature1.impl.screen.store.HomeState
import ru.otp.feature2.api.MoviesListComponentFactory
import kotlin.coroutines.CoroutineContext

internal class HomeComponentImpl(
    private val componentContext: HomeComponentContext,
    mainContext: CoroutineContext = Dispatchers.Main.immediate,
    private val moviesListComponent: MoviesListComponentFactory,
) : DecomposeComponent(),
    HomeComponent,
    ComponentContext by componentContext {

    private val koinScope = instanceKeeper
        .getOrCreate {
            ComponentKoinContext()
        }.getOrCreateKoinScope(
            listOf(feature1DIModule)
        )

    private val navigation = StackNavigation<RouteConfiguration>()

    private val scope = coroutineScope(mainContext + SupervisorJob())

    private val container = getOrCreateContainerHost {
        HomeContainerHost(
            coroutineScope = scope,
        )
    }

    private val stack = childStack(
        source = navigation,
        serializer = RouteConfiguration.serializer(),
        initialStack = { listOf(RouteConfiguration.None) },
        childFactory = ::child,
        handleBackButton = true,
    )

    override val childStack: Value<ChildStack<RouteConfiguration, DecomposeComponent>> = stack

    override val state: StateFlow<HomeComponent.ViewModel> = container.stateFlow.map {
        it.toViewModel()
    }.stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = container.stateFlow.value.toViewModel(),
    )

    init {
        scope.launch {
            container.sideEffectFlow.collect {
                navigation.push(
                    RouteConfiguration.MoviesList
                )
            }
        }
    }

    override fun onOpenMoviesListClicked() {
        container.onOpenMoviesListClicked()
    }

    private fun child(
        config: RouteConfiguration,
        componentContext: ComponentContext
    ): DecomposeComponent =
        when (config) {
            RouteConfiguration.MoviesList -> moviesListComponent(
                componentContext,
                deps = koinScope.get()
            )

            RouteConfiguration.None -> DecomposeComponent.EMPTY
        }

    @Composable
    override fun Render() {
        HomeContent(this)
    }
}

private fun HomeState.toViewModel() = HomeComponent.ViewModel(
    title = title,
    buttonIsEnabled = isLoading.not(),
)