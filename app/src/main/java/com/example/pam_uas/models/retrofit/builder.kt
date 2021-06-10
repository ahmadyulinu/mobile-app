package com.example.pam_uas.models.retrofit

import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

object builder {
    private const val BASE_URL = "http://192.168.0.103:8000/api/"



    val instance: API by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(API::class.java)
    }
}