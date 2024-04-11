package ru.otp.core.di

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.create
import com.arkivanov.essenty.lifecycle.destroy
import com.arkivanov.essenty.lifecycle.doOnDestroy

class DIComponentHolder<T : Any>(
    private val factory: (Lifecycle) -> T,
) : DIComponentProvider<T>, LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry()

    @Volatile
    private var component: T? = null

    @Volatile
    private var counter = 0

    override val lifecycle: Lifecycle = lifecycleRegistry

    /**
     * @param ownerLifecycle - Lifecycle потребителя компонента
     */
    @Synchronized
    override fun get(ownerLifecycle: Lifecycle): T {
        counter++

        ownerLifecycle.doOnDestroy {
            onEnd()
        }

        if (component == null) {
            component = create()
        }

        return component!!
    }

    @Synchronized
    private fun onEnd() {
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
