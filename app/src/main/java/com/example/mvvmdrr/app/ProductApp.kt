package com.example.mvvmdrr.app

import android.app.Application
import com.example.mvvmdrr.di.DaggerProductComponent
import com.example.mvvmdrr.di.ProductComponent

class ProductApp : Application() {
    companion object{
        lateinit var productComponent: ProductComponent
    }
    override fun onCreate() {
        super.onCreate()
        productComponent = DaggerProductComponent.factory().create(this)
    }

}