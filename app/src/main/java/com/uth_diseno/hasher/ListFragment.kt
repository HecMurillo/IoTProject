package com.uth_diseno.hasher


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController

import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class ListFragment : Fragment(), ArduinoAdapter.OnItemClickListener {
    private val navController: NavController by lazy {
        val navHostFragment = requireActivity().supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController
    }
    private val items: MutableList<Arduinos> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var arduinoAdapter: ArduinoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.hasherRecycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Agregar elementos a la lista
        items.add(
            Arduinos(
                1, "Arduinos", "Tipos de Arduino",
                "https://th.bing.com/th/id/R.898d403c1f607895f9f0e9178641d298?rik=6pO8Ek%2fpkr1inQ&pid=ImgRaw&r=0"
            )
        )
        items.add(
            Arduinos(
                2, "Componentes Básicos", "Componentes básicos de Arduino",
                "https://i.blogs.es/b929e0/mkr-iot/650_1200.jpg"
            )
        )
        items.add(
            Arduinos(
                3, "Componentes Avanzados", "Tipos de Arduino",
                "https://www.arduino.cc/en/uploads/Main/genuino_starter_components.jpg"
            )
        )
        items.add(
            Arduinos(
                4, "Resistencias", "Resistencias para Arduino",
                "https://uelectronics.com/wp-content/uploads/2019/05/AR0953-AR1029-Resistencia-0.5W.jpg"
            )
        )
        items.add(
            Arduinos(
                5, "Cables", "Tipos de Cables Utilizados en Arduino",
                "https://store.arduino.cc/cdn/shop/products/TPX00159_01.front_500x309.jpg?v=1683121087"
            )
        )

        arduinoAdapter = ArduinoAdapter(items)
        recyclerView.adapter = arduinoAdapter
        arduinoAdapter.onItemClickListener = this

        return view
    }

    override fun onItemClick(position: Int) {
        when (position) {
            0 -> navController.navigate(R.id.action_listFragment_to_arduinoItems)
            // 2 -> navController.navigate(R.id.action_listFragment_to_fragmentTwo)
            // 3 -> navController.navigate(R.id.action_listFragment_to_fragmentThree)
        }
    }
}
