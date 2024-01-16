package com.example.techfix

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.techfix.databinding.ActivityAmpliarImagenBinding

class AmpliarImagenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAmpliarImagenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmpliarImagenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra("imagenUrl")
        Glide.with(this).load(imageUrl).into(binding.imageAmpliada)
    }
}