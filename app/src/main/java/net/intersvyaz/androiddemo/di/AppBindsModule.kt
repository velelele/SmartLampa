package net.intersvyaz.androiddemo.di

import dagger.Binds
import dagger.Module
import net.intersvyaz.androiddemo.data.repository.SampleRepository
import net.intersvyaz.androiddemo.data.repository.SampleRepositoryImpl

@Module
interface AppBindsModule {
    @Binds
    fun bindSampleRepository(repository: SampleRepositoryImpl): SampleRepository
}