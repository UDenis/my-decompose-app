package ru.otp.feature2.impl.repository.dto

import kotlinx.serialization.Serializable
import ru.otp.feature2.impl.model.Movie

@Serializable
internal class MovieDto(
    val id: String,
    val name: String
)

internal fun MovieDto.asModel() = Movie(
    id = this.id,
    name = this.name,
)