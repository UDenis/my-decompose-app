package ru.otp.feature1.impl.repository

import me.tatarka.inject.annotations.Inject
import ru.otp.core.di.AppGraph
import ru.otp.feature1.api.repository.IFeature1Repository
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn

@SingleIn(AppGraph::class)
@ContributesBinding(AppGraph::class, IFeature1Repository::class)
@Inject
class Feature1RepositoryImpl : IFeature1Repository {
    override fun getSome(): String {
        return "Feature1RepositoryImpl"
    }
}