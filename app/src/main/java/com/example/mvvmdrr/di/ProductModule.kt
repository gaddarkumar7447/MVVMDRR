package com.example.mvvmdrr.di

import com.example.mvvmdrr.api.ProductInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ProductModule {

    @Singleton
    @Provides
    fun getApiIntence() : Retrofit{
        return Retrofit.Builder().baseUrl("https://fakestoreapi.com/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getApiProductInterface(retrofit: Retrofit) : ProductInterface{
        return retrofit.create(ProductInterface::class.java)
    }

}