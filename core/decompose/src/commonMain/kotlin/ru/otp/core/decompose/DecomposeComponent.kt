package ru.otp.core.decompose

import androidx.compose.runtime.Composable

abstract class DecomposeComponent {

    companion object {
        val EMPTY = object : DecomposeComponent() {
            @Composable
            override fun Render() {
            }
        }
    }

    @Composable
    abstract fun Render()
}