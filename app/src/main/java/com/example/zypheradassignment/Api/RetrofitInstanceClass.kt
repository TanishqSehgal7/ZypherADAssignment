package com.example.zypheradassignment.Api

import com.example.zypheradassignment.Interface.ZypherApi
import com.example.zypheradassignment.Util.BaseUrlConstant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceClass {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiService: ZypherApi by lazy {
        retrofit.create(ZypherApi::class.java)
    }
}