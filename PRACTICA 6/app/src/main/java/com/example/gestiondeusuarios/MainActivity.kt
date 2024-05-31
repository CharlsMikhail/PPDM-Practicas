package com.example.gestiondeusuarios

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

const val KEY_USUARIO = "usuario"
const val KEY_ADAPTER = "adapter"
const val KEY_POS = "pos"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}