package net.intersvyaz.androiddemo.di

import dagger.Component
import net.intersvyaz.androiddemo.presenter.sample.SampleFragment

@Component(
    modules = [ AppModule::class ]
)
interface AppComponent {
    fun inject(fragment: SampleFragment)
}