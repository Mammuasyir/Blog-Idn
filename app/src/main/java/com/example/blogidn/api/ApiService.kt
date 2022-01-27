package com.example.blogidn.api

import com.example.blogidn.model.ResponseBlog
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list_artikel.php")
    fun getBlog() : Call<ResponseBlog>
}