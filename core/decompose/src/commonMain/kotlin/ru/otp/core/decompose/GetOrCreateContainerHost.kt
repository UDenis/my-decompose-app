package ru.otp.core.decompose

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.arkivanov.essenty.lifecycle.create
import com.arkivanov.essenty.lifecycle.destroy
import kotlinx.coroutines.CoroutineScope

fun <T : Any> ComponentContext.getOrCreateContainerHost(
    key: Any,
    factory: ContainerFactoryContext.() -> T
): T {
    return instanceKeeper.getOrCreate(key) {
        ContainerHostHolder<T>().apply { create(factory) }
    }.containerHost
}

inline fun <reified T : Any> ComponentContext.getOrCreateContainerHost(noinline factory: ContainerFactoryContext.() -> T): T {
    return getOrCreateContainerHost(T::class, factory)
}

interface ContainerFactoryContext : LifecycleOwner {
    val scope: CoroutineScope
}

private class ContainerHostHolder<T : Any>() : InstanceKeeper.Instance, ContainerFactoryContext {

    lateinit var containerHost: T
        private set

    private val lifecycleRegistry = LifecycleRegistry()

    override val lifecycle: Lifecycle = lifecycleRegistry

    override val scope: CoroutineScope
        get() = coroutineScope()

    fun create(factory: ContainerFactoryContext.() -> T) {
        containerHost = factory()
        lifecycleRegistry.create()
    }

    override fun onDestroy() {
        lifecycleRegistry.destroy()
    }
}