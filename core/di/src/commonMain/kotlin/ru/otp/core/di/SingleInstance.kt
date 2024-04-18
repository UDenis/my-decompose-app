package ru.otp.core.di

import kotlinx.atomicfu.locks.reentrantLock
import kotlinx.atomicfu.locks.withLock
import kotlin.concurrent.Volatile

open class SingleInstance<T : Any>(
    private val factory: () -> T
) {

    private val lock = reentrantLock()

    @Volatile
    open protected var instance: T? = null

    fun get(): T {
        if (instance == null) {
            lock.withLock {
                if (instance == null) {
                    instance = factory()
                }
            }
        }
        return instance!!
    }
}
//
//open class WeakSingleInstance<T : Any>(
//    factory: () -> T
//) : SingleInstance<T>(factory) {
//
//    @kotlin.experimental.ExperimentalNativeApi
//    private var weakReference:WeakReference<T>? = null
//
//    override var instance: T?
//        get() = weakReference?.get()
//        set(value) {
//            if (value == null) {
//                weakReference = null
//            } else {
//                weakReference = WeakReference(value)
//            }
//        }
//}