package com.example.gestiondeusuarios.adapter

import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeusuarios.R
import com.example.gestiondeusuarios.Usuario

class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val viewNumTarjeta = itemView.findViewById<TextView>(R.id.txt_numero_tarjeta)
    private val btnEliminar = itemView.findViewById<ImageButton>(R.id.btn_eliminar_item_tarjeta)

    fun render(item: Usuario, onClickListener: (Usuario) -> Unit, l: OnClickListener) {
        viewNumTarjeta.text = item.nombre
        btnEliminar.setOnClickListener(l)
        itemView.setOnClickListener {
            onClickListener(item)
        }
    }
}
