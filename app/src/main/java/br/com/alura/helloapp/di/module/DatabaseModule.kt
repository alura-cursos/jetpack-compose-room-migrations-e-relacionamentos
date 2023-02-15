package br.com.alura.helloapp.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import br.com.alura.helloapp.database.ContatoDao
import br.com.alura.helloapp.database.HelloAppDatabase
import br.com.alura.helloapp.database.UsuarioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "helloApp.db"

val MIGRATION_1_2 = object : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS Usuario (`nomeDeUsuario` TEXT NOT NULL, `senha` TEXT NOT NULL, PRIMARY KEY(`nomeDeUsuario`))")
    }

}

val MIGRATION_5_6= object : Migration(5,6){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS ContatoCopia (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `sobrenome` TEXT NOT NULL, `telefone` TEXT NOT NULL, `fotoPerfil` TEXT NOT NULL, `aniversario` INTEGER, `idUsuario` TEXT NOT NULL DEFAULT '', FOREIGN KEY(`idUsuario`) REFERENCES `Usuario`(`idUsuario`) ON UPDATE NO ACTION ON DELETE CASCADE )")
        database.execSQL( "INSERT INTO ContatoCopia SELECT * FROM Contato")
        database.execSQL("DROP TABLE Contato")
        database.execSQL("ALTER TABLE ContatoCopia RENAME TO Contato")
    }
}

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): HelloAppDatabase {
        return Room.databaseBuilder(
            context,
            HelloAppDatabase::class.java,
            DATABASE_NAME
        ).addMigrations(MIGRATION_1_2,MIGRATION_5_6)
            .build()
    }

    @Provides
    fun provideContatoDao(db: HelloAppDatabase): ContatoDao {
        return db.contatoDao()
    }

    @Provides
    fun provideUsuarioDao(db: HelloAppDatabase): UsuarioDao {
        return db.usuarioDao()
    }
}