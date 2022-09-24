package com.example.jsontext

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoApi {
    @GET("posts")
    fun getTodos(): Call<List<Todo>>

    @GET("posts/{id}")
    fun getTodo(@Path("id") id:Int):Call<Todo>

}