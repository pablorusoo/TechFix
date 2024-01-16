package com.example.techfix

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private var usernameEditText: EditText? = null
    private var passwordEditText: EditText? = null
    private var loginButton: Button? = null
    private var registerLink: TextView? = null
    private val auth = FirebaseAuth.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        usernameEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.contraseña)
        loginButton = findViewById(R.id.botonLogin)
        registerLink = findViewById(R.id.nuevoRegistro)

        loginButton?.setOnClickListener(View.OnClickListener {
            val email = usernameEditText?.text.toString()
            val password = passwordEditText?.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            showToast("Inicio de sesión exitoso")
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            showToast("Inicio de sesión fallido.")
                        }
                    }
            } else {
                showToast("Por favor, ingresa correo electrónico y contraseña")
            }
        })

        registerLink?.setOnClickListener {
            // Navegar a la actividad de registro si el usuario hace clic en "Registro"
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }

    fun onRegisterLinkClick(view: View) {
        // Navegar a la actividad de registro si el usuario hace clic en el enlace
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
