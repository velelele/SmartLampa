package net.intersvyaz.androiddemo.data.repository

import net.intersvyaz.androiddemo.data.api.SampleService
import retrofit2.HttpException
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val service: SampleService,
) : SampleRepository {
    override suspend fun getJokesCategories(): Result<List<String>?> {
        kotlin.runCatching {
            service.getJokesCategories()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }
}