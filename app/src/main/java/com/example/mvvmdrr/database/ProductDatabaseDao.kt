package com.example.mvvmdrr.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmdrr.model.Product
import com.example.mvvmdrr.model.ProductItem

@Dao
interface ProductDatabaseDao {

    @Insert
    suspend fun productInsert(productItem: List<ProductItem>)

    @Query("SELECT * FROM localDB")
    suspend fun getAllProductFromDB() : List<ProductItem>

}