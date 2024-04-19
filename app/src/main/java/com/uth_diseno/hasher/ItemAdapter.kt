package com.uth_diseno.hasher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter(private val arduinoList: List<Arduinos>): RecyclerView.Adapter<ItemAdapter.ItemsViewHolder>(){

    class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.url_image)
        val textView: TextView = itemView.findViewById(R.id.list_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemsViewHolder, position: Int) {
        val item = arduinoList[position]
        Picasso.get().load(item.image)
            .into(holder.imageView)
        holder.textView.text = item.title
    }


    override fun getItemCount(): Int {
        return arduinoList.size
    }






}

