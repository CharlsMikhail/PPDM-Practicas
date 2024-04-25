package com.example.a1_interaccionconimagenesv3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription Se solicita, implentar fragmentos(al ejercicio 1 de pa PC-4) para hacer
 * el cambio entre "ventanas" asegurar no tienen que perder información de una a la otra,
 * estos fragmentos se comunican con botones, "siguiente" y "volver".
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 25/04/24
 * @lastModification 25/04/24
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            add(R.id.fragmentMenu, MenuFragment())
            commit()
        }

    }
}