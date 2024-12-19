package com.example.marcadorapp.di

package com.example.boardingapp.di

import android.content.Context
import androidx.room.Room
import com.example.marcadorapp.room.EquipoDao
import com.example.marcadorapp.room.PartidoDao
import com.example.marcadorapp.room.SetDao
import com.example.marcadorapp.room.VolleyballDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesEquipoDao(database: VolleyballDatabase): EquipoDao {
        return database.equipoDao()
    }

    @Singleton
    @Provides
    fun providesPartidoDao(database: VolleyballDatabase): PartidoDao {
        return database.partidoDao()
    }

    @Singleton
    @Provides
    fun providesSetDao(database: VolleyballDatabase): SetDao {
        return database.setDao()
    }

    @Singleton
    @Provides
    fun providesVolleyBallDatabase(@ApplicationContext context: Context): VolleyballDatabase {
        return Room.databaseBuilder(
            context,
            VolleyballDatabase::class.java, "volleyball_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}
