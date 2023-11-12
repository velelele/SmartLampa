package net.intersvyaz.androiddemo.di

import dagger.Module

@Module(
    includes = [
        ViewModelModule::class,
    ]
)
class AppModule