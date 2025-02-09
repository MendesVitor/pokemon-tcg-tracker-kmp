package db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import androidx.sqlite.execSQL
import data.db.AppDatabase
import data.db.instantiateImpl
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSFileManager
import platform.Foundation.NSHomeDirectory
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

fun getDatabaseBuilder(): AppDatabase {
    val dbFile = getDatabasePath()
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile,
        factory = { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(connection: SQLiteConnection) {
                super.onCreate(connection)
                connection.execSQL("INSERT INTO sets (id, name, releaseDate) VALUES (1, 'Base Set', '1999-01-09')")
                connection.execSQL("INSERT INTO sets (id, name, releaseDate) VALUES (2, 'Jungle', '1999-06-16')")
                connection.execSQL("INSERT INTO sets (id, name, releaseDate) VALUES (3, 'O impossivel aconteceu', '1999-06-16')")
            }
        })
        .build()
}

@OptIn(ExperimentalForeignApi::class)
fun getDatabasePath(): String {
    val paths = NSSearchPathForDirectoriesInDomains(
        directory = platform.Foundation.NSLibraryDirectory,
        domainMask = NSUserDomainMask,
        expandTilde = true
    )
    val libraryDir = paths.firstOrNull() ?: throw IllegalStateException("Library directory not found")

    val dbFolder = "$libraryDir/Application Support"
    val dbFile = "$dbFolder/tcg.db"

    val fileManager = NSFileManager.defaultManager
    if (!fileManager.fileExistsAtPath(dbFolder)) {
        fileManager.createDirectoryAtPath(dbFolder, withIntermediateDirectories = true, attributes = null, error = null)
    }

    return dbFile
}