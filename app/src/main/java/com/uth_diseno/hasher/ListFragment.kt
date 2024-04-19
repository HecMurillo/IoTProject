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

    private var hashers: MutableList<Arduinos> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        initData()

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)

        val adapter = ArduinoAdapter(hashers)

        val recyclerView = view.findViewById<RecyclerView>(R.id.hasherRecycler)




        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {
        hashers = mutableListOf(
            Arduinos(1, "Contra Face", "Hola Mundo", "perro", "F3ZS1NO7VU5IB8LY2RP9KH6WT4JMXGC", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(2, "Password", "abcdefg", "gato", "HSRJT8NWQZXY5PFAGVDCM9BU3IO7LKEX", "https://img2.wallspic.com/previews/1/8/6/4/7/174681/174681-instantanea-guante-verde-humanos-data-x750.jpg"),
            Arduinos(3, "Login", "12345678", "123", "LPVRS2GQJU7ZN1STCFMB3VXKR6Y9OAEH", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(4, "Insta", "987654321", "hola", "RLYXO9ZB2SH7TJFPWGDCM1NV5RQ8EX3A", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(5, "TikTok", "Hola Mundo", "erik", "U3LHVY9JX5MB7KO1IGPQ8ZR4STCN2AFE", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(6, "Microsoft", "abcdefg", "casa", "I8SPZR7LB2OK5EX9NM3GU6YV1JH4WQCF", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(7, "Login", "12345678", "hector", "Q6LR8SO9ZT4NY2AB7PK5EG1VH3IXJWCU", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(8, "Mercadolibre", "987654321", "mansion", "Z3NW7AS2XK9PQ1OH8LF4RM5GD6VBTYJU", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(9, "Telegram", "Hola Mundo", "tesla", "M4WO7RP9XG2VU5SD3IA1JF8LB6TYCNZH", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg"),
            Arduinos(10, "Laptop", "abcdefg", "google", "X1OY8LT6VP3ZB2SR7JH9MN4GQ5CWUFKD", "https://img2.wallspic.com/previews/9/5/4/4/7/174459/174459-retrato-entrecejo-nariz-piel-barbilla-x750.jpg")
        )
    }

    private fun generateSecretKey(): SecretKey {
        val keyGenerator = KeyGenerator.getInstance("AES")
        val secureRandom = SecureRandom()
        keyGenerator.init(256, secureRandom)
        return keyGenerator.generateKey()
    }

    private fun encrypt(data: String, key: SecretKey): ByteArray {
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        return cipher.doFinal(data.toByteArray())
    }

    private fun bytesToHexString(bytes: ByteArray): String {
        val hexChars = CharArray(bytes.size * 2)
        for (i in bytes.indices) {
            val v = bytes[i].toInt() and 0xFF
            hexChars[i * 2] = "0123456789ABCDEF"[v shr 4]
            hexChars[i * 2 + 1] = "0123456789ABCDEF"[v and 0x0F]
        }
        return String(hexChars)
    }
}