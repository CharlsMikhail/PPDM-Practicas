package com.example.a2_reproductordemusicav3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            add(R.id.menuMusicFragment, MenuMusicFragment())
            commit()
        }
    }
}