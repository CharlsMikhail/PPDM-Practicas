package com.example.gestiondeusuarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.gestiondeusuarios.adapter.UsuarioAdapter

class AgregarUsuarioFragment : Fragment(R.layout.fragment_agregar_usuario) {

    private lateinit var usuarioAdapter: UsuarioAdapter
    lateinit var cuentaAdd: Usuario

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            usuarioAdapter = it.getSerializable(KEY_ADAPTER) as UsuarioAdapter
        }
        eventos(view)
    }

    private fun eventos(view: View) {

        val etNombre = view.findViewById<EditText>(R.id.et_name)
        val etDNI = view.findViewById<EditText>(R.id.et_dni)
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val btnActualizarDatos = view.findViewById<Button>(R.id.btn_update)


        btnActualizarDatos.setOnClickListener {

            val nombre = etNombre.text.toString()
            val email = etEmail.text.toString()
            val dni = etDNI.text.toString().toInt()

            if (nombre.isEmpty()) {
                etNombre.error = "El nombre es requerido"
                return@setOnClickListener
            } else if (nombre.length > 20) {
                etNombre.error = "El nombre no puede tener más de 20 caracteres"
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "El email no es válido"
                return@setOnClickListener
            }

            if (dni.toString().length != 8) {
                etDNI.error = "El DNI no es válido"
                return@setOnClickListener
            }

            if (UsuarioProvider.listaUsuarios.any { it.dni == dni }){
                etDNI.error = "El DNI ya está registrado"
                return@setOnClickListener
            }
            cuentaAdd = Usuario(nombre, dni, email)

            usuarioAdapter.addTarjeta(cuentaAdd)
            Toast.makeText(view.context, "Usuario Agregado", Toast.LENGTH_SHORT).show()
            view.findNavController().popBackStack()

        }
    }

}