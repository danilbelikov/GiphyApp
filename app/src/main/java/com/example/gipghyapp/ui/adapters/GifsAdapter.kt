package com.example.gipghyapp.ui.adapters

import android.os.Build.VERSION.SDK_INT
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import com.bumptech.glide.Glide
import com.example.gipghyapp.R
import com.example.gipghyapp.models.Data
import kotlinx.android.synthetic.main.item_layout.view.*

class GifsAdapter(val itemClickListener: (Data) -> Unit): RecyclerView.Adapter<GifsAdapter.GifsViewHolder>() {
    inner class GifsViewHolder(view: View): RecyclerView.ViewHolder(view)

    private val callback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
           return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifsViewHolder {
        return GifsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent,false)
        )
    }

    override fun onBindViewHolder(holder: GifsViewHolder, position: Int) {
        val gif = differ.currentList[position]
        holder.itemView.apply {
//            val imageLoader = ImageLoader.Builder(context)
//                .components {
//                    if (SDK_INT >= 28) {
//                        add(ImageDecoderDecoder.Factory())
//                    } else {
//                        add(GifDecoder.Factory())
//                    }
//                }
//                .build()
//            ivGif.load(gif.url, imageLoader){
//                placeholder(R.drawable.ic_home)
//                error(R.drawable.ic_home)
//            }
//            Glide.with(this).asBitmap().load("https://media2.giphy.com/media/SggILpMXO7Xt6/200w.gif?cid=586aac78go77joev6h9rti1s7vf5h86o1wpjycceydj0eh2k&rid=200w.gif&ct=g")
            Glide.with(this).asGif().load(gif.images.original.url)
                .placeholder(R.drawable.ic_home).error(R.drawable.ic_home).into(ivGif)
            ivGif.clipToOutline = true

            ivGif.setOnClickListener {
                itemClickListener(differ.currentList[position])
            }

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    private var onItemClickListener: ((Data) -> Unit)? = null

    fun setOnItemClickListener(listener: (Data) -> Unit){
        onItemClickListener = listener
    }
}