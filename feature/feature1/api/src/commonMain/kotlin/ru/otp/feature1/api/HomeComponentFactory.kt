package ru.otp.feature1.api

import com.arkivanov.decompose.ComponentContext
import ru.otp.core.decompose.DecomposeComponent
import ru.otp.core.di.ComponentKoinContext

typealias HomeComponentFactory = (ComponentContext, ComponentKoinContext)->DecomposeComponent