package com.example.techfix

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegistroActivity : AppCompatActivity() {
    private var emailEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var registerButton: Button? = null
    private var backButton: Button? = null
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.contraseña)
        registerButton = findViewById(R.id.botonGuardar)
        backButton = findViewById(R.id.botonVolver)

        registerButton?.setOnClickListener(View.OnClickListener {
            val email = emailEditText?.text.toString()
            val contraseña = passwordEditText?.text.toString()

            if (email.isNotEmpty() && contraseña.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, contraseña)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            showToast("Registro exitoso")
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            showToast("Error en el registro: ${task.exception?.message}")
                        }
                    }
            } else {
                showToast("Por favor, ingresa correo electrónico y contraseña")
            }
        })

        backButton?.setOnClickListener(View.OnClickListener {
            if (backButton!!.isPressed){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}