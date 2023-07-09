package com.example.practicafinalmodulo4

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practicafinalmodulo4.databinding.FragmentInicioDeSesionBinding

class InicioDeSesionFragment : Fragment(R.layout.fragment_inicio_de_sesion) {

    private lateinit var binding : FragmentInicioDeSesionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInicioDeSesionBinding.bind(view)

        //        INGRESO
        binding.btIngresar.setOnClickListener{

            var correo = binding.etEmail.text
            var contrasena = binding.etPassword.text

            if (correo.isNotEmpty() && contrasena.isNotEmpty()) {
                val secondIntent = Intent(requireContext(), HomeActivity::class.java).apply {

                    putExtra("EXTRA_EMAIL", correo.toString())
                    putExtra("EXTRA_PASSWORD", contrasena.toString())
                }
                startActivity(secondIntent)
            } else {
                // Al menos uno de los campos está vacío, mostrar un mensaje de error
                Toast.makeText(requireContext(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        //         CREA UNA CUENTA NUEVA
        binding.tvCreaCuenta.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .addToBackStack("RegistroFragment")
                .replace(R.id.fragmentContainerView,RegistroFragment.newInstance())
                .commit()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio_de_sesion, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = InicioDeSesionFragment()
    }
}