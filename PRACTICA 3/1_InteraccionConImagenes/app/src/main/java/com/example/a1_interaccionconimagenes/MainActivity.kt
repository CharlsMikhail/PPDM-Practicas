package com.example.a1_interaccionconimagenes

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription Se solicita, implementar un boton que contenga una imagen y al presionar esta
 * se muestre en pantalla un mensaje personalizado usando Toast.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 13/04/24
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txt_custom = findViewById<EditText>(R.id.txt_custom)
        val btn_imgb = findViewById<ImageButton>(R.id.imgb_main)
        btn_imgb.setOnClickListener() {
            //val msg = "Acabas de hacer click en la imagen :)"
            Toast.makeText(this, txt_custom.text, Toast.LENGTH_SHORT).show()
        }
    }
}