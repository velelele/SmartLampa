package net.intersvyaz.androiddemo.data.api

import retrofit2.Response
import retrofit2.http.GET

interface SampleService {
    @GET("jokes/categories")
    suspend fun getJokesCategories(): Response<List<String>>
}