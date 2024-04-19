package com.uth_diseno.hasher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArduinoItems.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArduinoItems : Fragment() {
    // TODO: Rename and change types of parameters
    private val items: MutableList<Arduinos> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_arduino_items, container, false)

        recyclerView = view.findViewById(R.id.ItemRecycler)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Agregar elementos a la lista
        items.add(Arduinos(1,"Arduino Uno","Versátil y popular para proyectos básicos","https://res.cloudinary.com/rsc/image/upload/b_rgb:FFFFFF,c_pad,dpr_2.625,f_auto,h_214,q_auto,w_380/c_pad,h_214,w_380/F7697409-01?pgw=1"))
        items.add(Arduinos(2,"Arduino Mega","Ampliado, adecuado para proyectos complejos","https://core-electronics.com.au/media/catalog/product/cache/d5cf359726a1656c2b36f3682d3bbc67/a/0/a000067-arduino-mega-2560-1front.jpg"))
        items.add(Arduinos(3,"Arduino Esplora   ","Diseñado para proyectos de aprendizaje y exploración, con una variedad de sensores y componentes integrados.","https://m.media-amazon.com/images/I/41HTH5AFIZL._AC_UF1000,1000_QL80_.jpg"))
        items.add(Arduinos(4,"Arduino Leonardo","Ofrece emulación de dispositivos USB, ideal para proyectos de interfaz de usuario y simulación.","https://ipowerelectronics.com.mx/3635-large_default/tarjeta-arduino-leonardo-32u4-sin-cable-usb.jpg"))
        items.add(Arduinos(5,"Arduino Nano","Compacto, ideal para proyectos con espacio limitado.","https://uelectronics.com/wp-content/uploads/2023/08/AR3733-Arduino-Nano-ESP32-ABX00092.jpg"))
        items.add(Arduinos(6,"Arduino Due","Potente, con rendimiento superior para aplicaciones avanzadas.","https://http2.mlstatic.com/D_NQ_NP_625659-MLM52818830336_122022-O.webp"))

        itemAdapter = ItemAdapter(items)
        recyclerView.adapter = itemAdapter

        return view
    }
}