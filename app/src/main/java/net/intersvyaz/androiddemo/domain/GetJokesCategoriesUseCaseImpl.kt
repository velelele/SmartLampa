package net.intersvyaz.androiddemo.domain

import net.intersvyaz.androiddemo.data.repository.SampleRepository
import javax.inject.Inject

class GetJokesCategoriesUseCaseImpl @Inject constructor(
    private val repository: SampleRepository,
): GetJokesCategoriesUseCase {
    override suspend fun invoke(): Result<List<String>?> =
        repository.getJokesCategories()

}