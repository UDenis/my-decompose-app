import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.ComponentContext
import platform.UIKit.UIViewController
import ru.otp.app.di.AppDI
import ru.otp.core.design.MyApplicationTheme

fun MainViewController(
    rootComponentContext: ComponentContext,
    appDI: AppDI,
): UIViewController {
    return ComposeUIViewController {
        MyApplicationTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                MaterialTheme {
                    appDI
                        .homeComponentFactory(rootComponentContext)
                        .Render()
                }
            }
        }
    }
}