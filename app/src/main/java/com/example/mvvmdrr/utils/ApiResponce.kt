package com.example.mvvmdrr.utils

sealed class ApiResponce<T>(val apiData: T? = null, val message: String? = null) {
    class Loading<T> : ApiResponce<T>()
    class Successful<T>(data: T?) : ApiResponce<T>(apiData = data)
    class Error<T>(error: String?) : ApiResponce<T>(message = error)
}
