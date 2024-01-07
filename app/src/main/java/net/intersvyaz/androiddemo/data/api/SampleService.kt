package net.intersvyaz.androiddemo.data.api

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SampleService {

    @GET("color/names_only")
    suspend fun getColors(): Response<List<String>>

    @POST("state/on")
    suspend fun turnOnLamp(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOffLamp(): Response<Boolean>

    @FormUrlEncoded
    @POST("brightness/")
    suspend fun setBrightness(@Field("level") level: Int): Response<Boolean>

    @FormUrlEncoded
    @POST("color/")
    suspend fun setColor(@Field("color")color: String): Response<Boolean>

}