package ru.otp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import ru.otp.android.compose.RootContent
import ru.otp.android.di.AppDI
import ru.otp.core.design.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = defaultComponentContext()
        val appDI = AppDI()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    RootContent(
                        rootComponentContext = root,
                        appDI = appDI,
                    )
                }
            }
        }
    }
}