package com.example.gestiondeusuarios

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

const val KEY_USUARIO = "usuario"
const val KEY_ADAPTER = "adapter"
const val KEY_POS = "pos"


/**
 * @problemDescription Se solicita el diseño de un CRUD, usando Recycler View y Card View para GESTION DE USUARIOS.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 28/05/24
 * @lastModification 31/05/24
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}