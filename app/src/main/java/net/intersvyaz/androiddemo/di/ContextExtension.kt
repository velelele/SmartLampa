package net.intersvyaz.androiddemo.di

import android.content.Context
import net.intersvyaz.androiddemo.MyApplication

val Context.appComponent: AppComponent
    get() = when(this) {
        is MyApplication -> appComponent
        else -> applicationContext.appComponent
    }