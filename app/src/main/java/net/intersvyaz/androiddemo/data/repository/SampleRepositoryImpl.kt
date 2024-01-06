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

    override suspend fun getColors(): Result<List<String>?> {

        kotlin.runCatching {
            service.getColors()
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

    override suspend fun turnOnLamp(): Result<Boolean?> {

        kotlin.runCatching {
            service.turnOnLamp()
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

    override suspend fun turnOffLamp(): Result<Boolean?> {

        kotlin.runCatching {
            service.turnOffLamp()
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