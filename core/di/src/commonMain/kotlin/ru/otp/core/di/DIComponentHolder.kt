package ru.otp.core.di

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.atomicfu.locks.reentrantLock
import kotlinx.atomicfu.locks.withLock
import kotlin.concurrent.Volatile

class DIComponentHolder<T : DIComponent>(
    private val factory: () -> T,
) : DIComponentProvider<T> {

    private val lock = reentrantLock()

    @Volatile
    private var component: T? = null

    @Volatile
    private var counter = 0

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

    private fun onEnd() = lock.withLock {
        counter--
        if (counter <= 0) {
            component?.onDestroy()
            component = null
            counter = 0
        }
    }

    private fun create(): T {
        return factory().apply {
            onCreate()
        }
    }
}
