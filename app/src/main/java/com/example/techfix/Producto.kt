package com.example.techfix

// Producto.kt

data class Producto(
    val imagenUrl: String,
    val iconoUrl: String,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val caracteristica1: String,
    val caracteristica2: String,
    val caracteristica3: String
    // Puedes agregar más atributos según sea necesario
)
