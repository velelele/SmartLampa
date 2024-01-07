package net.intersvyaz.androiddemo.domain

import net.intersvyaz.androiddemo.data.repository.SampleRepository
import javax.inject.Inject

class SetBrightnessUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
): SetBrightnessUseCase {
    override suspend fun invoke(level: Int): Result<Boolean?> =
        repository.setBrightness(level)
}