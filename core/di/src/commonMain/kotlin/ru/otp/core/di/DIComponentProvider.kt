package ru.otp.core.di

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner

fun interface DIComponentProvider<T : Any> {
    fun get(lifecycle: Lifecycle): T

    fun get(lifecycleOwner: LifecycleOwner) = get(lifecycleOwner.lifecycle)
}

