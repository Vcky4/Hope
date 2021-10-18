package com.vicksoson.hope.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("items")
    fun getItems(): Call<List<RecyclerResponse>>
}