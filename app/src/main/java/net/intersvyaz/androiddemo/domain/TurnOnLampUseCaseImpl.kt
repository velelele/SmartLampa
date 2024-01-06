package net.intersvyaz.androiddemo.domain

import net.intersvyaz.androiddemo.data.repository.SampleRepository
import javax.inject.Inject

class TurnOnLampUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
): TurnOnLampUseCase {
    override suspend fun invoke(): Result<Boolean?> =
        repository.turnOnLamp()
}