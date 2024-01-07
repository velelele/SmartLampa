package net.intersvyaz.androiddemo.domain

import net.intersvyaz.androiddemo.data.repository.SampleRepository
import javax.inject.Inject

class GetColorsUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
): GetColorsUseCase {
    override suspend fun invoke(): Result<List<String>?> =
        repository.getColors()

}