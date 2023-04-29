package com.example.mvvmdrr.model

import org.json.JSONObject

data class Rating(
    val count: Int,
    val rate: Double
) {

    fun toJson(): String {
        val jsonObject = JSONObject()
        jsonObject.put("rate", rate)
        jsonObject.put("count", count)
        return jsonObject.toString()
    }

    companion object {
        fun fromJson(json: String): Rating {
            val jsonObject = JSONObject(json)
            val rate = jsonObject.getDouble("rate")
            val count = jsonObject.getInt("count")
            return Rating(count, rate)
        }

    }
}
