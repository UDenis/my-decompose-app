package ru.otp.feature1.impl.screen

import kotlinx.serialization.Serializable

@Serializable
internal sealed interface RouteConfiguration {

    data object None : RouteConfiguration

    @Serializable
    data object MoviesList : RouteConfiguration
}