package com.uth_diseno.hasher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ArduinoAdapter(private val arduinoList: List<Arduinos>) : RecyclerView.Adapter<ArduinoAdapter.ArduinosViewHolder>() {

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class ArduinosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.url_image)
        val textView: TextView = itemView.findViewById(R.id.list_title)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArduinosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ArduinosViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arduinoList.size
    }

    override fun onBindViewHolder(holder: ArduinosViewHolder, position: Int) {
        val item = arduinoList[position]
        Picasso.get().load(item.image).into(holder.imageView)
        holder.textView.text = item.title
    }
}