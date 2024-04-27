package ru.otp.core.di

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.create
import com.arkivanov.essenty.lifecycle.destroy

abstract class DIComponent : LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry()

    override val lifecycle: Lifecycle = lifecycleRegistry

    internal fun onCreate() {
        lifecycleRegistry.create()
    }

    internal fun onDestroy() {
        lifecycleRegistry.destroy()
    }
}