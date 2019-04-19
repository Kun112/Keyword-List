package com.anhquan.keywordsample.data.remote

import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("v2/keywords.json")
    fun getKeywordList(): Observable<ArrayList<String>>
}