package com.example.techfix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.techfix.databinding.ActivityMostrarDatosBinding

class MostrarDatosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMostrarDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra("imagenUrl")
        val iconoUrl = intent.getStringExtra("iconoUrl")
        val nombre = intent.getStringExtra("nombre")
        val descripcion = intent.getStringExtra("descripcion")
        val precio = intent.getDoubleExtra("precio", 0.0)
        val caracteristica1 = intent.getStringExtra("caracteristica1")
        val caracteristica2 = intent.getStringExtra("caracteristica2")
        val caracteristica3 = intent.getStringExtra("caracteristica3")

        Glide.with(this).load(imageUrl).into(binding.imagenProducto)

        binding.nombreProducto.text = nombre
        binding.descripcionProducto.text = descripcion
        binding.precioProducto.text = precio.toString()
        binding.caracteristica1.text = caracteristica1
        binding.caracteristica2.text = caracteristica2
        binding.caracteristica3.text = caracteristica3
    }
}

