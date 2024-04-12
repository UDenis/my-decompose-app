package ru.otp.feature1.impl.screen.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import ru.otp.feature1.impl.screen.HomeComponent

@Composable
internal fun HomeContent(
    component: HomeComponent,
) {
    val vm = component.state.collectAsState(
        component.state.value
    )

    Column {
        Text(
            text = vm.value.title,
        )

        Button(
            onClick = { component.onOpenMoviesListClicked() },
            enabled = vm.value.buttonIsEnabled,
        ) {
            Text(
                text = "Открыть список фильмов",
            )
        }

        Spacer(
            Modifier.height(20.dp)
        )

        Children(
            stack = component.childStack,
        ) {
            it.instance.Render()
        }
    }
}

//
////@Preview
//@Composable
//private fun HomePreview() {
//    val fakeHomeComponent = object : HomeComponent {
//        override val state: StateFlow<HomeComponent.ViewModel> = MutableStateFlow(
//            HomeComponent.ViewModel(
//                title = "Hello",
//                buttonIsEnabled = true,
//            )
//        )
//
//        override val childStack: Value<ChildStack<RouteConfiguration, HomeComponent.Child>> = TODO()
//
//        override fun onOpenMoviesListClicked() {
//            Log.d("FakeHomeComponent", "onOpenMoviesListClicked")
//        }
//    }
//    HomeContent(fakeHomeComponent) {}
//}
