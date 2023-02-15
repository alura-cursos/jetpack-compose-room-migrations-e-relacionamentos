package br.com.alura.helloapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    foreignKeys = [ForeignKey(
        Usuario::class,
        parentColumns = ["idUsuario"],
        childColumns = ["idUsuario"],
        onDelete = CASCADE
    )]
)
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nome: String = "",
    val sobrenome: String = "",
    val telefone: String = "",
    val fotoPerfil: String = "",
    val aniversario: Date? = null,
    @ColumnInfo(defaultValue = "")
    val idUsuario: String = ""
)