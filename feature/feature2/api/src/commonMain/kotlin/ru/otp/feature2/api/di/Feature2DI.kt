package ru.otp.feature2.api.di

import ru.otp.core.di.DIComponent
import ru.otp.feature2.api.MoviesListComponentFactory

abstract class Feature2DI : DIComponent() {
    abstract val moviesListComponentFactory: MoviesListComponentFactory
}