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
                db.execSQL("INSERT INTO sets (id, name, releaseDate) VALUES (1, 'Base Set', '1999-01-09')")
                db.execSQL("INSERT INTO sets (id, name, releaseDate) VALUES (2, 'Jungle', '1999-06-16')")
            }
        })
        .build()
}