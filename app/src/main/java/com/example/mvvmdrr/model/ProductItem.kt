package com.example.mvvmdrr.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("localDB")
data class ProductItem(
    val category: String,
    val description: String,

    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val image: String,
    val price: Double,
    //val rating: Rating?,
    val title: String
)