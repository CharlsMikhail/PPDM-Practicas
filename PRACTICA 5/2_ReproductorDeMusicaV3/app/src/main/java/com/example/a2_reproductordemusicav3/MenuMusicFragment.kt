package com.example.a2_reproductordemusicav3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

const val KEY_MSG = "res"
const val REQUEST_CODE = "menu"
const val KEY_MSC = "music"

class MenuMusicFragment : Fragment(R.layout.fragment_menu_music) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spnMusic = view.findViewById<Spinner>(R.id.spn_music)
        val btnSelect = view.findViewById<Button>(R.id.btn_select)

        // Configuramos el sipinner con la lista de músicas
        val options = listOf("1. Creep", "2. Cumbia Boliviana", "3. Pumped Up Kicks", "4. In My Head", "5. Paredon" )
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item_custom, options)
        spnMusic.adapter = adapter

        requireActivity().supportFragmentManager.setFragmentResultListener(REQUEST_CODE, this) {
                requestKey, bundle ->
            val result = bundle.getString(KEY_MSG)
            Toast.makeText(requireContext(), result, Toast.LENGTH_LONG).show()
        }

        btnSelect.setOnClickListener {
            // Preparamos el cambio de actividad
            val selected = spnMusic.selectedItemPosition

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.menuMusicFragment, ReproductorFragment.newInstance(selected))
                addToBackStack(REQUEST_CODE) // manda a la pila a el fragmento antes de remplazarlo.
                commit()
            }
        }
    }
}