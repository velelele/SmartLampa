package net.intersvyaz.androiddemo

import android.app.Application
import net.intersvyaz.androiddemo.di.AppComponent
import net.intersvyaz.androiddemo.di.DaggerAppComponent

class MyApplication : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .create()
    }
}