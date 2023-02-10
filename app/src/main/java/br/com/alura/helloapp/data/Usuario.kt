package br.com.alura.helloapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey
    val nomeDeUsuario: String = "",
    val senha: String = "",
)
