package ru.otp.core.di

expect class WeakReference<T : Any>(referred: T) {
    fun clear()
    fun get(): T?
}