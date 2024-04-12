package ru.otp.feature1.impl.repository

import ru.otp.feature1.api.repository.IFeature1Repository

internal class Feature1RepositoryImpl : IFeature1Repository {
    override fun getSome(): String {
        return "Feature1RepositoryImpl"
    }
}