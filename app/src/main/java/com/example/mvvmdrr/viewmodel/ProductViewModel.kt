package com.example.mvvmdrr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdrr.model.Product
import com.example.mvvmdrr.repository.ProductRepostory
import com.example.mvvmdrr.utils.ApiResponce
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepostory: ProductRepostory) : ViewModel() {
    val productLiveData : LiveData<ApiResponce<Product>> = productRepostory.productLiveData
    fun getProductData(){
        viewModelScope.launch {
            productRepostory.getProductItem()
        }
    }

}