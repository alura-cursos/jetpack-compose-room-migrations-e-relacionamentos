package br.com.alura.helloapp.database

import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import br.com.alura.helloapp.data.Contato
import br.com.alura.helloapp.data.Usuario
import br.com.alura.helloapp.database.converters.*

@Database(
    entities = [Contato::class, Usuario::class],
    version = 6,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(2, 3),
        AutoMigration(3, 4, Migration3to4::class),
        AutoMigration(4, 5),
        AutoMigration(5, 6),
    ]
)
@TypeConverters(Converters::class)
abstract class HelloAppDatabase : RoomDatabase() {
    abstract fun contatoDao(): ContatoDao
    abstract fun usuarioDao(): UsuarioDao
}


@RenameColumn(
    "Usuario",
    "nomeDeUsuario",
    "idUsuario"
)
class Migration3to4 : AutoMigrationSpec