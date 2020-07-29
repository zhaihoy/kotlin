package com.example.kotlin.http

class BaseResponse<T> {
    var data: T? = null
    var errorMsg = ""
    var errorCode = 0
}