package com.example.gestiondeusuarios.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.gestiondeusuarios.Usuario

class UsuarioAdapter(private val items: MutableList<Usuario>, private val idLayout: Int, val onItemSelected: (Usuario) -> Unit): RecyclerView.Adapter<UsuarioViewHolder>() {

    lateinit private var context2: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        context2 = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(idLayout, parent, false)
        return UsuarioViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val item = items[position]
        holder.render(item, onItemSelected) {
            deleteTarjeta(position, item)
        }
    }

    fun addTarjeta(tarjeta: Usuario) {
        items.add(0, tarjeta)
        notifyItemInserted(0)
    }

    private fun deleteTarjeta(index: Int, item: Usuario) {

        val builder = AlertDialog.Builder(context2)
        builder.setTitle("Confirmación")
        builder.setMessage("¿Estás seguro de que deseas eliminar esta tarjeta: ${item.nombre}?")
        builder.setPositiveButton("Sí") { _, _ ->
            // Acción a realizar si el usuario confirma la eliminación

            items.removeAt(index)
            notifyItemRemoved(index)
            notifyItemRangeChanged(index, items.size)
            Toast.makeText(context2, "Tarjeta eliminada correctamente", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancelar") { dialog, _ ->
            // Acción a realizar si el usuario cancela la eliminación
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }


    fun editTarjeta(index: Int, tarjeta: Usuario) {
        items[index] = tarjeta
        notifyItemChanged(index)
    }
}
