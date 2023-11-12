package net.intersvyaz.androiddemo.di

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
        NetworkModule::class,
        AppBindsModule::class,
    ]
)
class AppModule