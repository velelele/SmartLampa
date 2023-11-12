package net.intersvyaz.androiddemo.di

import dagger.Module
import dagger.Provides
import net.intersvyaz.androiddemo.data.api.SampleService
import retrofit2.Retrofit

@Module
class NetworkModule {

    @Provides
    fun provideSampleService(): SampleService =
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .build()
            .create(SampleService::class.java)

}