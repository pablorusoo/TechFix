package com.example.techfix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techfix.databinding.ActivityListarPorIconoBinding

class ListarPorIconoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListarPorIconoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarPorIconoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtén la categoría/icono deseada
        val categoria = intent.getStringExtra("categoria")

        // TODO: Obtén la lista de productos que pertenecen a esa categoría desde Firestore
        val listaProductos = mutableListOf<Producto>() // Reemplaza con la lista real

        val adapter = ProductosAdapter(listaProductos)
        binding.recyclerViewListarPorIcono.adapter = adapter
        binding.recyclerViewListarPorIcono.layoutManager = LinearLayoutManager(this)
    }
}
