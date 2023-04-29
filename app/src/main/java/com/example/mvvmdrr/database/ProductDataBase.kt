package com.example.mvvmdrr.database

import android.content.Context
import androidx.room.*
import com.example.mvvmdrr.model.ProductItem
import javax.inject.Inject

@Database(entities = [ProductItem::class], version = 1)
//@TypeConverters(RatingConverter::class)
abstract class  ProductDataBase : RoomDatabase(){
    abstract fun getDao() : ProductDatabaseDao
}
