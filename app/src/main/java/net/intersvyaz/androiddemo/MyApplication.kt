package net.intersvyaz.androiddemo

import android.app.Application
import net.intersvyaz.androiddemo.di.DaggerAppComponent

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent
            .create()
    }

}