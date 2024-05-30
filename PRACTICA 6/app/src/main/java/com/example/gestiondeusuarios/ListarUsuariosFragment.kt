package com.example.gestiondeusuarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeusuarios.adapter.UsuarioAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListarUsuariosFragment : Fragment(R.layout.listar_contactos) {

    private lateinit var usuarioAdapter: UsuarioAdapter
    private lateinit var usuarioActual: Usuario

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycleView(view)
        eventos(view)

    }

    private fun eventos(view: View) {
        val btnAdd = view.findViewById<FloatingActionButton>(R.id.btnAddTarjeta)

        btnAdd.setOnClickListener{
            view.findNavController().navigate(R.id.action_listarUsuariosFragment_to_editarUsuarioFragment)
        }
    }

    private fun initRecycleView(view: View) {
        val manager = LinearLayoutManager(context)
        usuarioAdapter = UsuarioAdapter(UsuarioProvider.listaUsuarios, R.layout.item_tarjeta_x) { user -> onItemSelected(user)} //ojito
        val decoration = DividerItemDecoration(context, manager.orientation)
        val usersRecyler = view.findViewById<RecyclerView>(R.id.lista_tarjetas_x)
        usersRecyler.layoutManager = manager
        usersRecyler.adapter = usuarioAdapter
        usersRecyler.addItemDecoration(decoration)
    }

    private fun onItemSelected(user: Usuario) {
        Toast.makeText(context, "Hola " + user.nombre, Toast.LENGTH_SHORT).show()
    }
}