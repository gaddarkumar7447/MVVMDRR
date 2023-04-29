package com.example.mvvmdrr.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdrr.repository.ProductRepostory
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory @Inject constructor(private val repostory: ProductRepostory) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repostory) as T
    }
}