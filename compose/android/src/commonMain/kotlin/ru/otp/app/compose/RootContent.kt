package ru.otp.app.compose

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.DefaultComponentContext
import ru.otp.app.di.AppDI

@Composable
fun RootContent(
    rootComponentContext: ComponentContext,
    appDI: AppDI,
) {

    appDI
        .feature1DI.get(rootComponentContext)
        .homeComponentFactory(rootComponentContext)
        .Render()
}
