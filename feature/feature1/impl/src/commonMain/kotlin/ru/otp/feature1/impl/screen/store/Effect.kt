package ru.otp.feature1.impl.screen.store

internal sealed interface Effect {
    sealed interface Navigation : Effect {
        data object MoviesList : Navigation
    }
}