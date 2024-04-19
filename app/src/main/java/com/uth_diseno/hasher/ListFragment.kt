package com.uth_diseno.hasher

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey


class ListFragment : Fragment() {

    private lateinit var hashers: MutableList<Arduinos>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        initData()

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = ArduinoAdapter(hashers) { position ->
            navigateToFragment(position + 1) // Sumamos 1 a la posición para que coincida con el fragmento
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.hasherRecycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }

    private fun initData() {
        val title1 = requireContext().getString(R.string.title1)
        val text1 = requireContext().getString(R.string.text1)
        // Define tus demás datos aquí

        hashers = mutableListOf(
            Arduinos(1, title1, text1, "https://th.bing.com/th/id/R.898d403c1f607895f9f0e9178641d298?rik=6pO8Ek%2fpkr1inQ&pid=ImgRaw&r=0"),
            // Define tus demás datos aquí
        )
    }

    private fun navigateToFragment(fragmentNumber: Int) {

            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            // Verifica si hay un fragmento presente y elimínalo
            val existingFragment = fragmentManager.findFragmentById(R.id.fragment_container)
            existingFragment?.let { fragmentTransaction.remove(it) }

            when (fragmentNumber) {
                1 -> fragmentTransaction.replace(R.id.fragment_container, FirstFragment())
                // Agrega más casos según sea necesario para tus fragmentos
            }

            fragmentTransaction.commit()
    }
}