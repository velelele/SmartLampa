package net.intersvyaz.androiddemo.data.repository

import net.intersvyaz.androiddemo.data.api.SampleService
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val service: SampleService,
) : SampleRepository {
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

    override suspend fun setBrightness( level: Int): Result<Boolean?> {

        kotlin.runCatching {
            service.setBrightness(level)
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

    override suspend fun setColor( color: String): Result<Boolean?> {

        kotlin.runCatching {
            service.setColor(color)
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