package com.example.mvvmdrr.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdrr.api.ProductInterface
import com.example.mvvmdrr.database.ProductDataBase
import com.example.mvvmdrr.database.ProductDatabaseDao
import com.example.mvvmdrr.model.Product
import com.example.mvvmdrr.utils.ApiResponce
import javax.inject.Inject

class ProductRepostory @Inject constructor(private val productInterface: ProductInterface, private val productDatabaseDao: ProductDataBase) {

    private val productMutableLiveData = MutableLiveData<ApiResponce<Product>>()
    val productLiveData : LiveData<ApiResponce<Product>> = productMutableLiveData

    suspend fun getProductItem(){
        try {
            productMutableLiveData.value = ApiResponce.Loading()
            val responce = productInterface.getProduct().body()
            if (responce != null){
                productMutableLiveData.value = ApiResponce.Successful(responce)
                productDatabaseDao.getDao().productInsert(responce)
            }else{
                productMutableLiveData.value = ApiResponce.Error("Somethings went to wrong in backend")
            }
        }catch (e : Exception){
            productMutableLiveData.value = ApiResponce.Error("Something went to wrong")
        }
    }
}