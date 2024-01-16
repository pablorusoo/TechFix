package com.example.techfix

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var productosAdapter: ProductosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewProductos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtener datos de Firebase y configurar el adaptador
        obtenerDatosDeFirebase()
    }

    private fun obtenerDatosDeFirebase() {
        val db = FirebaseFirestore.getInstance()

        db.collection("productos")
            .get()
            .addOnSuccessListener { result ->
                val listaProductos = mutableListOf<Producto>()
                for (document in result) {
                    val imagenUrl = document.getString("imagenUrl") ?: ""
                    val iconoUrl = document.getString("iconoUrl") ?: ""
                    val nombre = document.getString("nombre") ?: ""
                    val descripcion = document.getString("descripcion") ?: ""
                    val precio = document.getDouble("precio") ?: 0.0
                    val caracteristica1 = document.getString("caracteristica1") ?: ""
                    val caracteristica2 = document.getString("caracteristica2") ?: ""
                    val caracteristica3 = document.getString("caracteristica3") ?: ""

                    val producto = Producto(imagenUrl, iconoUrl, nombre, descripcion, precio, caracteristica1, caracteristica2, caracteristica3)
                    listaProductos.add(producto)
                }

                productosAdapter = ProductosAdapter(listaProductos)
                recyclerView.adapter = productosAdapter
            }
            .addOnFailureListener { exception ->
                // Manejar errores al obtener datos de Firebase
                Toast.makeText(this, "Error al obtener datos de Firebase: $exception", Toast.LENGTH_SHORT).show()
            }
    }
}