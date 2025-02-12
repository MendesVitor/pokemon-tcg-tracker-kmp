package db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import domain.model.Set

fun getDatabaseBuilder(ctx: Context): AppDatabase {
    val dbFile = ctx.getDatabasePath("tcg.db")

    return Room.databaseBuilder(ctx, AppDatabase::class.java, dbFile.absolutePath)
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                // Insere os dados diretamente via SQL
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (1, 'Base Set', '1999-01-09', 'Base')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (2, 'Jungle', '1999-06-16', 'Base')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (3, 'Mascaras', '2024-01-09', 'Scarlet&Violet')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (4, 'Prismatic', '2025-06-16', 'Scarlet&Violet')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (5, 'Teste', '2000-06-16', 'Base')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (6, 'Outro Test', '2024-06-09', 'Scarlet&Violet')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (7, 'Teste', '2000-06-16', 'Espada e Escudo')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (8, 'Outro Test', '2024-06-09', 'Espada e Escudo')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (9, 'Teste', '2000-06-16', 'B & W')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate, category) VALUES (10, 'Outro Test', '2024-06-09', 'XY')")
            }
        })
        .build()
}