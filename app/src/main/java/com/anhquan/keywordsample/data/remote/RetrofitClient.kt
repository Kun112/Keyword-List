package com.anhquan.keywordsample.data.remote

import com.anhquan.keywordsample.util.Constant
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient{

    private lateinit var retrofit: Retrofit
    private lateinit var apiService: ApiService

    init {
        initComponents()
    }

    private fun initComponents() {
        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .baseUrl(Constant.URL)
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    fun getApiService(): ApiService {
        return apiService
    }

}