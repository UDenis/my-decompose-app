package ru.otp.feature1.impl.screen

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.di.ComponentKoinContext

class HomeComponentContext(
    val componentKoinContext: ComponentKoinContext,
    componentContext: ComponentContext,
) : ComponentContext by componentContext