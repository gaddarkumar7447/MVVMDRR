package com.example.mvvmdrr.database

import androidx.room.TypeConverter
import com.example.mvvmdrr.model.Rating

class RatingConverter {
    @TypeConverter
    fun fromRating(rating: Rating?): String? {
        return rating?.toJson()
    }

    @TypeConverter
    fun toRating(ratingString: String?): Rating? {
        return ratingString?.let {
            Rating.fromJson(it)
        }
    }
}