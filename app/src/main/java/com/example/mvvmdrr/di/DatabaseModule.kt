package com.example.mvvmdrr.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmdrr.database.ProductDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {


    @Singleton
    @Provides
    fun getRoomInstance(context: Context): ProductDataBase {
        synchronized(this) {
            return Room.databaseBuilder(context, ProductDataBase::class.java, "localDB").build()
        }
    }

}