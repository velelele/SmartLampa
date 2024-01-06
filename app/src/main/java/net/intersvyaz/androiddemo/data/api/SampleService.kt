package net.intersvyaz.androiddemo.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface SampleService {
    @GET("jokes/categories")
    suspend fun getJokesCategories(): Response<List<String>>

    @GET("color/names_only")
    suspend fun getColors(): Response<List<String>>

    @POST("state/on")
    suspend fun turnOnLamp(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOffLamp(): Response<Boolean>
}