package ru.otp.core.di

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.reflect.KClass

@Retention(RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ComponentDeps(
    val deps: Array<KClass<out DIComponent>>
)
