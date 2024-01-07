package net.intersvyaz.androiddemo.di

import dagger.Binds
import dagger.Module
import net.intersvyaz.androiddemo.data.repository.SampleRepository
import net.intersvyaz.androiddemo.data.repository.SampleRepositoryImpl
import net.intersvyaz.androiddemo.domain.GetColorsUseCase
import net.intersvyaz.androiddemo.domain.GetColorsUseCaseImpl
import net.intersvyaz.androiddemo.domain.SetBrightnessUseCase
import net.intersvyaz.androiddemo.domain.SetBrightnessUseCaseImpl
import net.intersvyaz.androiddemo.domain.SetColorUseCase
import net.intersvyaz.androiddemo.domain.SetColorUseCaseImpl
import net.intersvyaz.androiddemo.domain.TurnOffLampUseCase
import net.intersvyaz.androiddemo.domain.TurnOffLampUseCaseImpl
import net.intersvyaz.androiddemo.domain.TurnOnLampUseCase
import net.intersvyaz.androiddemo.domain.TurnOnLampUseCaseImpl

@Module
interface AppBindsModule {
    @Binds
    fun bindSampleRepository(repository: SampleRepositoryImpl): SampleRepository

    @Binds
    fun bindGetColorsUseCase(useCase: GetColorsUseCaseImpl): GetColorsUseCase

    @Binds
    fun bindTurnOnLampUseCase(useCase: TurnOnLampUseCaseImpl) : TurnOnLampUseCase

    @Binds
    fun bindTurnOffLampUseCase(useCase: TurnOffLampUseCaseImpl) : TurnOffLampUseCase
    @Binds
    fun bindSetBrightnessUseCase(useCase: SetBrightnessUseCaseImpl) : SetBrightnessUseCase

    @Binds
    fun bindSetColorUseCase(useCase: SetColorUseCaseImpl) : SetColorUseCase
}
