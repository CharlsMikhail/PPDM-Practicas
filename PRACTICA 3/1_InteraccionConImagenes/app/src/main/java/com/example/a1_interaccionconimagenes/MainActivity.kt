package com.example.a1_interaccionconimagenes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription PC3 - Se solicita, mostrar una imagen, al presionar la imagen: se muestre
 * en pantalla un mensaje personalizado usando Toast, el mensaje se saca de un EditText.
 * @problemDescription PC4 - Se solicita, agregar un Spinner para poder seleccionar más imagenes
 * , implentar otra actividad; ambas no tienen que perder información de una a la otra, estas
 * actividades se comunican con botones, "siguiente" y "volver".
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 16/04/24
 */

const val REQUEST_CODE = 123
const val KEY_TEXT = "text"
const val KEY_IMG = "image"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtCustom = findViewById<EditText>(R.id.txt_custom)
        val spnImages = findViewById<Spinner>(R.id.spn_images)
        val btnSelect = findViewById<Button>(R.id.btn_select)

        val options = listOf("imagen1", "imagen2", "imagen3")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        spnImages.adapter = adapter

        btnSelect.setOnClickListener {
            // Preparamos el cambio de actividad
            val msg = txtCustom.text.toString()
            val selected = spnImages.selectedItemPosition

            // Creamos el intent() para guardar y despúes recueprar en la otra actividad
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(KEY_TEXT, msg)
            intent.putExtra(KEY_IMG, selected)

            startActivityForResult(intent, REQUEST_CODE)
        }

    }


    // Forma antigua
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE ) {
            if (resultCode == Activity.RESULT_OK) {
                // Recuperamos el texto escrito anteriormente
                val recoverdText = data?.getStringExtra(KEY_TEXT)
                val editText = findViewById<EditText>(R.id.txt_custom)
                editText.setText(recoverdText)

                val recoveredImg = data?.getIntExtra(KEY_IMG, 0).toString().toInt()
                val spnImage = findViewById<Spinner>(R.id.spn_images)
                spnImage.setSelection(recoveredImg)

                Toast.makeText(this, "Volvimos", Toast.LENGTH_LONG).show()
            }
        }
    }
}



