package br.com.alura.helloapp.di.module

import android.content.Context
import androidx.room.Room
import br.com.alura.helloapp.database.ContatoDao
import br.com.alura.helloapp.database.HelloAppDatabase
import br.com.alura.helloapp.database.UsuarioDao
import br.com.alura.helloapp.database.migrations.MIGRATION_1_2
import br.com.alura.helloapp.database.migrations.MIGRATION_5_6
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "helloApp.db"



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