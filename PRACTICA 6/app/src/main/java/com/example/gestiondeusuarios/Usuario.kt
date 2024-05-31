package com.example.gestiondeusuarios

import java.io.Serializable

data class Usuario (
    var nombre: String,
    var dni: Int,
    var email: String,
): Serializable
