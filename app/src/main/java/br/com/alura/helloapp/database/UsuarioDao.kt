package br.com.alura.helloapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.alura.helloapp.data.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insere(usuario: Usuario)

    @Query("SELECT * FROM Usuario")
    fun buscaTodos(): Flow<List<Usuario>>

    @Query("SELECT * FROM Usuario WHERE idUsuario = :usuario")
    fun buscaPorId(usuario: String) : Flow<Usuario?>
}