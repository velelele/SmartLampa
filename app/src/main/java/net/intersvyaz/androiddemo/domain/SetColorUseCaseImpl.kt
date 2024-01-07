package net.intersvyaz.androiddemo.domain

import net.intersvyaz.androiddemo.data.repository.SampleRepository
import javax.inject.Inject

class SetColorUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
): SetColorUseCase {
    override suspend fun invoke(color: String): Result<Boolean?> =
        repository.setColor(color)
}