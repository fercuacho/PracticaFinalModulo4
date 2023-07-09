package com.example.practicafinalmodulo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicafinalmodulo4.databinding.ActivityHomeBinding
import com.example.practicafinalmodulo4.user.User

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val nombre = intent.getStringExtra("EXTRA_NAME")
        val apellido = intent.getStringExtra("EXTRA_LAST_NAME")
        val correo = intent.getStringExtra("EXTRA_EMAIL")
        val contrasena = intent.getStringExtra("EXTRA_PASSWORD")

        //val user = intent.getSerializableExtra("EXTRA_USER") as User

        binding.tvName.text = nombre
        binding.tvLastName.text = apellido
        binding.tvEmail.text = correo
        binding.tvPassword.text = contrasena

//        binding.tvName.text = user.name
//        binding.tvLastName.text = user.lastName
//        binding.tvEmail.text = user.email
//        binding.tvPassword.text = user.password

    }
}