package com.example.gestiondeusuarios

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.gestiondeusuarios.adapter.UsuarioAdapter
import kotlin.properties.Delegates

class EditarUsuarioFragment : Fragment(R.layout.fragment_editar_usuario) {

    lateinit var cuentaEditar: Usuario
    private lateinit var usuarioAdapter: UsuarioAdapter
    private var posicion by Delegates.notNull<Int>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            cuentaEditar = it.getSerializable(KEY_USUARIO) as Usuario
            usuarioAdapter = it.getSerializable(KEY_ADAPTER) as UsuarioAdapter
            posicion= it.getInt(KEY_POS)
        }

        actualizarInterfaz(view)
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

            if (UsuarioProvider.listaUsuarios.any { it.dni == dni && it.dni != cuentaEditar.dni }){
                etDNI.error = "El DNI ya está registrado"
                return@setOnClickListener
            }
            cuentaEditar.nombre = nombre
            cuentaEditar.email = email
            cuentaEditar.dni = dni

            usuarioAdapter.editTarjeta(posicion, cuentaEditar)

            view.findNavController().popBackStack()

        }
    }

    private fun actualizarInterfaz(view: View) {
        val etNombre = view.findViewById<EditText>(R.id.et_name)
        val etDNI = view.findViewById<EditText>(R.id.et_dni)
        val etEmail = view.findViewById<EditText>(R.id.et_email)

        etNombre.setText(cuentaEditar.nombre)
        etDNI.setText(cuentaEditar.dni.toString())
        etEmail.setText(cuentaEditar.email)
    }
}