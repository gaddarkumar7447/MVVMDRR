package com.example.mvvmdrr.api

import com.example.mvvmdrr.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductInterface {

    @GET("products")
    suspend fun getProduct() : Response<Product>
}