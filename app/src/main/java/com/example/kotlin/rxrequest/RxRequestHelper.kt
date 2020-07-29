package com.example.kotlin.rxrequest

import com.example.kotlin.http.ApiService

object RxRequestHelper {
    var apiService: ApiService? = null

    init {
        apiService =
            RetrofitFactory.factory().create(ApiService::class.java)
    }
}