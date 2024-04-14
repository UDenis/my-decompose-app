package ru.otp.core.di

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.create
import com.arkivanov.essenty.lifecycle.destroy
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.atomicfu.locks.reentrantLock
import kotlinx.atomicfu.locks.withLock
import kotlin.concurrent.Volatile

class DIComponentHolder<T : Any>(
    private val factory: (Lifecycle) -> T,
) : DIComponentProvider<T>, LifecycleOwner {

    val lock = reentrantLock()

    private val lifecycleRegistry = LifecycleRegistry()

    @Volatile
    private var component: T? = null

    @Volatile
    private var counter = 0

    override val lifecycle: Lifecycle = lifecycleRegistry

    /**
     * @param ownerLifecycle - Lifecycle потребителя компонента
     */
    override fun get(ownerLifecycle: Lifecycle): T = lock.withLock {

        counter++

        ownerLifecycle.doOnDestroy {
            onEnd()
        }

        if (component == null) {
            component = create()
        }

        return component!!
    }

    private fun onEnd() =  lock.withLock {
        counter--
        if (counter <= 0) {
            lifecycleRegistry.destroy()
            component = null
            counter = 0
        }
    }

    private fun create(): T {
        lifecycleRegistry.create()
        return factory(lifecycle)
    }
}
