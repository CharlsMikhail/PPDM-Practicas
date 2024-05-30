package com.example.gestiondeusuarios

import java.io.Serializable

data class Usuario(
    var nombre: String,
    var edad: Int,
    var email: String,
    var password: String
):Serializable
