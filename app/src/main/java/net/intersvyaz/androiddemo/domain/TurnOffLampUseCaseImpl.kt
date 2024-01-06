package net.intersvyaz.androiddemo.domain

import net.intersvyaz.androiddemo.data.repository.SampleRepository
import javax.inject.Inject

class TurnOffLampUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
): TurnOffLampUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOffLamp()
}