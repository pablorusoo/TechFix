package com.example.techfix

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.techfix.databinding.ItemProductoBinding

class ProductosAdapter(private val listaProductos: List<Producto>) :
    RecyclerView.Adapter<ProductosAdapter.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ItemProductoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]

        Glide.with(holder.itemView.context).load(producto.iconoUrl).into(holder.binding.iconoProducto)
        holder.binding.nombreProducto.text = producto.nombre
        holder.binding.precioProducto.text = producto.precio.toString()

        holder.itemView.setOnClickListener {
            // Manejar clic en cualquier parte del elemento
            val intent = Intent(holder.itemView.context, MostrarDatosActivity::class.java).apply {
                // Pasa los datos del producto a la nueva actividad
                putExtra("imagenUrl", producto.imagenUrl)
                putExtra("iconoUrl", producto.iconoUrl)
                putExtra("nombre", producto.nombre)
                putExtra("descripcion", producto.descripcion)
                putExtra("precio", producto.precio)
                putExtra("caracteristica1", producto.caracteristica1)
                putExtra("caracteristica2", producto.caracteristica2)
                putExtra("caracteristica3", producto.caracteristica3)
            }
            holder.itemView.context.startActivity(intent)
        }

        // Puedes agregar un listener similar para el icono si es necesario
        // holder.binding.icono.setOnClickListener { /* Manejar clic en el icono */ }
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    class ProductoViewHolder(val binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)
}