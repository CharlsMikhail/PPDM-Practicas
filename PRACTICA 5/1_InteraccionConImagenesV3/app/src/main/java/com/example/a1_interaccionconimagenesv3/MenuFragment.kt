package com.example.a1_interaccionconimagenesv3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment

const val REQUEST_CODE = "123"
const val KEY_TEXT = "text"
const val KEY_IMG = "image"

class MenuFragment : Fragment(R.layout.fragment_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtCustom = view.findViewById<EditText>(R.id.txt_custom)
        val spnImages = view.findViewById<Spinner>(R.id.spn_images)
        val btnSelect = view.findViewById<Button>(R.id.btn_select)

        val options = listOf("Corazon", "Retrato", "Goku")
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item_custom, options)
        spnImages.adapter = adapter


        requireActivity().supportFragmentManager.setFragmentResultListener(REQUEST_CODE, this) {
                requestKey, bundle ->
            val result = bundle.getString(KEY_MSG)
            Toast.makeText(requireContext(), result, Toast.LENGTH_LONG).show()
        }


        btnSelect.setOnClickListener {
            // Preparamos el cambio de actividad
            val msg = txtCustom.text.toString()
            val selected = spnImages.selectedItemPosition

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentMenu, ImageFragment.newInstance(msg, selected))
                addToBackStack(REQUEST_CODE) // manda a la pila a el fragmento antes de remplazarlo.
                commit()
            }

        }
    }
}