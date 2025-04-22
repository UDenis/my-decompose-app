package ru.otp.app

import ru.otp.core.di.AppGraph
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@MergeComponent(AppGraph::class)
@SingleIn(AppGraph::class)
abstract class IOSAppDI : AppDI

expect fun getIOSAppComponent(): IOSAppDI

