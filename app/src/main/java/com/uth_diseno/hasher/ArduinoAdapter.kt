package com.uth_diseno.hasher

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ArduinoAdapter(private var hasherList: List<Arduinos>): RecyclerView.Adapter<ArduinoAdapter.HashersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HashersViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_hashers, parent, false)
        return HashersViewHolder(view)
    }

    override fun onBindViewHolder(holder: HashersViewHolder, position: Int) {
        val hash = hasherList[position]
        holder.render(hash)

        //aquí se aplica la lógica. ej: onClickListener

    }

    override fun getItemCount(): Int {
        return hasherList.size
    }

    class HashersViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.url_image)
        val title: TextView = view.findViewById(R.id.hash_title)
        val hashing: TextView = view.findViewById(R.id.hash)
        val id: TextView = view.findViewById(R.id.hash_id)
        val key: TextView = view.findViewById(R.id.hash_key)

        @SuppressLint("SetTextI18n")
        fun render(hash: Arduinos) {
            Picasso.get().load(hash.image).into(image)
            title.text = hash.title + ": "
            hashing.text = hash.hashEncryptet
            id.text = hash.id.toString() + " Key: "
            key.text = hash.key
        }
    }
}