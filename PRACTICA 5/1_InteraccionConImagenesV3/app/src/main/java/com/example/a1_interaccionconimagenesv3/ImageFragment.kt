package com.example.a1_interaccionconimagenesv3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

val KEY_MSG = "res"

class ImageFragment : Fragment(R.layout.fragment_image) {

    private var mensaje: String? = ""
    private var imgSelected: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mensaje = requireArguments().getString(KEY_TEXT)
        imgSelected = requireArguments().getInt(KEY_IMG)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recupero las información del fragmento 1


        val imgMain = view.findViewById<ImageButton>(R.id.imgb_main)

        imgMain.setImageResource(
            when (imgSelected) {
                0 -> R.drawable.imagen1
                1 -> R.drawable.imagen2
                2 -> R.drawable.imagen3
                else -> R.drawable.imagen1
            }
        )

        imgMain.setOnClickListener {
            Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
        }

        val btnBack = view.findViewById<Button>(R.id.btn_return)

        btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(
                KEY_MSG to getString(R.string.txt_volvimos)))
            requireActivity().supportFragmentManager.popBackStack()
        }
    }
    // es un objeto estatico.
    companion object {

        // Fun para pasar información
        fun newInstance(nombre: String, edad: Int) = ImageFragment().apply {
            // 1ra forma
            val datos = Bundle()
            datos.putString(KEY_TEXT, nombre)
            datos.putInt(KEY_IMG, edad)
            arguments = datos

            // 2da forma
            //arguments.bundleOf(KEY_TEXT to nombre, KEY_IMG to edad)

        }
    }
}