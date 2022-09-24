package com.example.jsontext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        JsServer.todoApi.getTodos().enqueue(object:Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                Log.d("Result", "Response Received - ${response.code()}")
                val resultList = response.body()
                resultList?.let{
                    for(i in 0..3)
                        Log.d("Result", it[i].title)
                }
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {
                Log.e("Result", t.message.toString())
            }

        })
    }
}