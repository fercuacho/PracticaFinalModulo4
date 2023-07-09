package com.example.practicafinalmodulo4

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practicafinalmodulo4.databinding.FragmentInicioDeSesionBinding
import com.example.practicafinalmodulo4.databinding.FragmentRegistroBinding
import com.example.practicafinalmodulo4.user.User


class RegistroFragment : Fragment(R.layout.fragment_registro) {

    private lateinit var binding: FragmentRegistroBinding
    //private val userList : List? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistroBinding.bind(view)

        var nombre = binding.etNombre.text
        var apellido = binding.etApellido.text
        var correo = binding.etEmail.text
        var contrasena = binding.etPassword.text

        //val user = User("${binding.etNombre.text}", apellido.toString(),"hombre", correo.toString(),contrasena.toString() )

        binding.btSend.setOnClickListener{
            if (correo.isNotEmpty() && contrasena.isNotEmpty() && nombre.isNotEmpty() && apellido.isNotEmpty()) {
                val intent = Intent(requireContext(), HomeActivity::class.java).apply {
                    //  putExtra("EXTRA_USER", user)
                    putExtra("EXTRA_NAME", nombre.toString())
                    putExtra("EXTRA_LAST_NAME", apellido.toString())
                    putExtra("EXTRA_EMAIL", correo.toString())
                    putExtra("EXTRA_PASSWORD", contrasena.toString())
                }
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

//        binding.btComprobar.setOnClickListener{
//            Toast.makeText(requireContext(), "Texto: $nombre", Toast.LENGTH_SHORT).show()
//        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance() = RegistroFragment()
    }
}