package net.intersvyaz.androiddemo.di

import dagger.Module
import dagger.Provides
import net.intersvyaz.androiddemo.data.api.SampleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideSampleService(): SampleService =
        Retrofit.Builder()
            .baseUrl("http://195.54.14.121:8086/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SampleService::class.java)

}