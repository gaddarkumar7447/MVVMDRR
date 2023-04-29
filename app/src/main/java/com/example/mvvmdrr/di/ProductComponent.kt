package com.example.mvvmdrr.di

import android.content.Context
import com.example.mvvmdrr.activity.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ProductModule::class, DatabaseModule::class])
interface ProductComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ProductComponent

    }
}