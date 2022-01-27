package com.example.blogidn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blogidn.api.ApiConfig
import com.example.blogidn.model.ResponseBlog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ApiConfig.getService().getBlog().enqueue(object : Callback<ResponseBlog>{
//            override fun onResponse(call: Call<ResponseBlog>, response: Response<ResponseBlog>) {
//                if (response.isSuccessful){
//                    val responseBlog = response.body()
//                    val msg = responseBlog?.message
//                    if (msg != null) {
//                        Log.d("MainActivity", msg)
//                        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<ResponseBlog>, t: Throwable) {
//                Log.d("MainActivity", "error di" + t.localizedMessage)
//                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            }
//        })

        val rvBlog = findViewById<RecyclerView>(R.id.rv_blog)

        ApiConfig.getService().getBlog().enqueue(object : Callback<ResponseBlog>{
            override fun onResponse(call: Call<ResponseBlog>, response: Response<ResponseBlog>) {
                if (response.isSuccessful){
                    val responseBlog = response.body()
                    val dataBlog = responseBlog?.dataArtikel
                    val blogAdapter = BlogAdapter(dataBlog)
                    rvBlog.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        blogAdapter.notifyDataSetChanged()
                        adapter = blogAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseBlog>, t: Throwable) {
                Log.d("MainActivity", "error di" + t.localizedMessage)
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}