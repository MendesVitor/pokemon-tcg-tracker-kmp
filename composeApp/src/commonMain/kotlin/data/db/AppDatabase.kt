package data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import data.dao.SetDao
import domain.model.Set

@Database(entities = [Set::class], version = 1)
abstract class AppDatabase : RoomDatabase(), DB {
    abstract fun setDao(): SetDao
    override fun clearAllTables(): Unit {}
}

interface DB {
    fun clearAllTables(): Unit {}
}
