package ru.otp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import ru.otp.core.design.MyApplicationTheme
import ru.otp.feature1.impl.screen.HomeComponentContext
import ru.otp.feature1.impl.screen.HomeComponentImpl
import ru.otp.feature2.impl.screen.MoviesListComponentImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = defaultComponentContext()
        val appDI = (applicationContext as AppDelegateOwner).appDelegate.componentKoinContext
        val homeComponent = HomeComponentImpl(
            componentContext = HomeComponentContext(
                componentKoinContext = appDI,
                componentContext = root,
            ),
            moviesListComponent = {
                MoviesListComponentImpl(
                    componentContext = it,
                )
            }
        )

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    homeComponent.Render()
                }
            }
        }
    }
}