package com.example.blogidn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blogidn.model.DataArtikelItem

class BlogAdapter(val dataArtikelItem: List<DataArtikelItem?>?) : RecyclerView.Adapter<BlogAdapter.MyViewHolder>() {

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgBlog = view.findViewById<ImageView>(R.id.item_image_blog)
        val tvJudul = view.findViewById<TextView>(R.id.item_tv_judul)
        val tvPenulis = view.findViewById<TextView>(R.id.item_tv_author)
        val tvTanggal = view.findViewById<TextView>(R.id.item_tv_tanggal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_blog, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvJudul.text = dataArtikelItem?.get(position)?.judul
        holder.tvPenulis.text = dataArtikelItem?.get(position)?.author
        holder.tvTanggal.text = dataArtikelItem?.get(position)?.tglPosting

        Glide.with(holder.imgBlog)
            .load(dataArtikelItem?.get(position)?.gambar)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgBlog)
    }

    override fun getItemCount(): Int {
        if (dataArtikelItem != null) {
            return dataArtikelItem.size
        }
        return 0
    }
}