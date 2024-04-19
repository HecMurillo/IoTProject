package com.uth_diseno.hasher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ArduinoAdapter(
    private val hasherList: List<Arduinos>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<ArduinoAdapter.HashersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HashersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return HashersViewHolder(view)
    }

    override fun onBindViewHolder(holder: HashersViewHolder, position: Int) {
        val hash = hasherList[position]
        holder.render(hash)

        holder.itemView.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return hasherList.size
    }

    class HashersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.url_image)
        val title: TextView = view.findViewById(R.id.list_title)
        val id: TextView = view.findViewById(R.id.list_text)

        fun render(hash: Arduinos) {
            Picasso.get().load(hash.image).into(image)
            title.text = hash.title
            id.text = hash.text
        }
    }
}