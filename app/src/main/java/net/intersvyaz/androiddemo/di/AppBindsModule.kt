package net.intersvyaz.androiddemo.di

import dagger.Binds
import dagger.Module
import net.intersvyaz.androiddemo.data.repository.SampleRepository
import net.intersvyaz.androiddemo.data.repository.SampleRepositoryImpl
import net.intersvyaz.androiddemo.domain.GetJokesCategoriesUseCase
import net.intersvyaz.androiddemo.domain.GetJokesCategoriesUseCaseImpl
import net.intersvyaz.androiddemo.domain.TurnOffLampUseCase
import net.intersvyaz.androiddemo.domain.TurnOffLampUseCaseImpl
import net.intersvyaz.androiddemo.domain.TurnOnLampUseCase
import net.intersvyaz.androiddemo.domain.TurnOnLampUseCaseImpl

@Module
interface AppBindsModule {
    @Binds
    fun bindSampleRepository(repository: SampleRepositoryImpl): SampleRepository

    @Binds
    fun bindGetJokesCategoriesUseCase(useCase: GetJokesCategoriesUseCaseImpl): GetJokesCategoriesUseCase

    @Binds
    fun bindTurnOnLampUseCase(useCase: TurnOnLampUseCaseImpl) : TurnOnLampUseCase

    @Binds
    fun bindTurnOffLampUseCase(useCase: TurnOffLampUseCaseImpl) : TurnOffLampUseCase
}
