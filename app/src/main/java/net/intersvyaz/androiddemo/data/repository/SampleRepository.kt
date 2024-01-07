package net.intersvyaz.androiddemo.data.repository

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.Query

interface SampleRepository {


    suspend fun getColors(): Result<List<String>?>

    suspend fun turnOnLamp(): Result<Boolean?>

    suspend fun turnOffLamp(): Result<Boolean?>

    suspend fun setBrightness(level: Int): Result<Boolean?>

    suspend fun setColor(color: String): Result<Boolean?>
}

