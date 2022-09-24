package com.example.jsontext

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JsServer {
    companion object{
        private const val url = "https://jsonplaceholder.typicode.com"
        private var server:Retrofit=Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var todoApi:TodoApi = server.create(TodoApi::class.java)
    }
}