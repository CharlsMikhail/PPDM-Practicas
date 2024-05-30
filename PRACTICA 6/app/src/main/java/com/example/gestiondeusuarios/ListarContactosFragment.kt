package com.example.gestiondeusuarios

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListarContactosFragment : Fragment(R.layout.listar_contactos) {

    private lateinit var userAdapter: ContactoAdapter

    private lateinit var cuentaActual: CuentaUsuario
    private lateinit var usuarioActual: Usuario
    private lateinit var personaActual: Persona

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            cuentaActual = it.getSerializable(KEY_CUENTA_USUARIO) as CuentaUsuario
            usuarioActual = it.getSerializable(KEY_USUARIO) as Usuario
            personaActual = it.getSerializable(KEY_PERSONA) as Persona
        }

        initRecycleView(view)
        eventos(view)
    }

    private fun eventos(view: View) {
        val btnBack = view.findViewById<ImageButton>(R.id.btn_atras)

        btnBack.setOnClickListener() {
            view.findNavController().popBackStack()
        }

        val btnNumber = view.findViewById<FloatingActionButton>(R.id.btnNumber)
        btnNumber.setOnClickListener{
            showDialogNumber(view)
        }
    }

    private fun showDialogNumber(view: View) {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Ingresar Número: ")

        // Inflar el layout del EditText desde el XML
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_number, null)

        // Obtener la referencia al EditText del layout inflado
        val input = dialogView.findViewById<EditText>(R.id.editTextPhoneNumber)

        dialog.setView(dialogView)

        dialog.setPositiveButton("Buscar") { _, _ ->
            val inputNumber = input.text.toString()

            // Validar el número de teléfono ingresado
            if (inputNumber.isBlank()) {
                Toast.makeText(requireContext(), "Por favor, ingrese un número.", Toast.LENGTH_SHORT).show()
            } else if (!isValidPhoneNumber(inputNumber)) {
                Toast.makeText(requireContext(), "Número de teléfono inválido.", Toast.LENGTH_SHORT).show()
            } else {
                val daoCueUsu = CuentaUsuarioDAO(requireContext())
                val cuentaDestino = daoCueUsu.obtenerUsuarioDestinoPorNumMovil(inputNumber.toInt())
                if (cuentaDestino != null && inputNumber.toInt() != cuentaActual.num_movil) {
                    val delivery = Bundle()
                    delivery.putSerializable(KEY_CUENTA_USUARIO, cuentaActual)
                    delivery.putSerializable(KEY_USUARIO, usuarioActual)
                    delivery.putSerializable(KEY_PERSONA, personaActual)
                    delivery.putSerializable(KEY_USUARIO_DESTINO, cuentaDestino)
                    view.findNavController().navigate(R.id.action_listarContactosFragment_to_pagarFragment, delivery)
                }
                else if (inputNumber.toInt() == cuentaActual.num_movil) {
                    Toast.makeText(requireContext(), "No puede trasferirse a si mismo", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(requireContext(), "El número ${inputNumber.toInt()} no pertence a TPAGO", Toast.LENGTH_SHORT).show()
                }
            }
        }

        dialog.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
            Toast.makeText(requireContext(), "Cancelado", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }

    // Función para validar el número de teléfono (simple ejemplo)
    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        // Este es un ejemplo simple, se puede mejorar según las necesidades
        val phoneNumberPattern = "^\\d{9}$"
        return phoneNumber.matches(phoneNumberPattern.toRegex())
    }


    private fun initRecycleView(view: View) {
        val manager = LinearLayoutManager(context)
        userAdapter = ContactoAdapter(ContactoProvider.listaContactos) {user -> onItemSelected(user)} //ojito
        val decoration = DividerItemDecoration(context, manager.orientation)
        val usersRecyler = view.findViewById<RecyclerView>(R.id.lista_usuarios)
        usersRecyler.layoutManager = manager
        usersRecyler.adapter = userAdapter
        usersRecyler.addItemDecoration(decoration)
    }


    private fun onItemSelected(user:Contacto) {
        val daoCueUsu = CuentaUsuarioDAO(requireContext())
        val cuentaDestino = daoCueUsu.obtenerUsuarioDestinoPorNumMovil(user.numMovil)
        if (cuentaDestino != null && user.numMovil != cuentaActual.num_movil) {
            val delivery = Bundle()
            delivery.putSerializable(KEY_CUENTA_USUARIO, cuentaActual)
            delivery.putSerializable(KEY_USUARIO, usuarioActual)
            delivery.putSerializable(KEY_PERSONA, personaActual)
            delivery.putSerializable(KEY_USUARIO_DESTINO, cuentaDestino)
            view?.findNavController()?.navigate(R.id.action_listarContactosFragment_to_pagarFragment, delivery)
        }
        else if (user.numMovil == cuentaActual.num_movil) {
            Toast.makeText(requireContext(), "No puede trasferirse a si mismo", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(requireContext(), "El contacto ${user.nombres} no pertence a TPAGO", Toast.LENGTH_SHORT).show()
        }
    }
}