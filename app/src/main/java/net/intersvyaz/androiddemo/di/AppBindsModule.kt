package net.intersvyaz.androiddemo.di

import dagger.Binds
import dagger.Module
import net.intersvyaz.androiddemo.data.repository.SampleRepository
import net.intersvyaz.androiddemo.data.repository.SampleRepositoryImpl
import net.intersvyaz.androiddemo.domain.GetJokesCategoriesUseCase
import net.intersvyaz.androiddemo.domain.GetJokesCategoriesUseCaseImpl

@Module
interface AppBindsModule {
    @Binds
    fun bindSampleRepository(repository: SampleRepositoryImpl): SampleRepository

    @Binds
    fun bindGetJokesCategoriesUseCase(useCase: GetJokesCategoriesUseCaseImpl): GetJokesCategoriesUseCase
}