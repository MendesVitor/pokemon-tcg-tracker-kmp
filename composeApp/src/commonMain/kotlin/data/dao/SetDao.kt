package data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import domain.model.Set
import org.koin.core.component.KoinComponent


@Dao
interface SetDao {
    @Query("SELECT * FROM sets")
    suspend fun getAllSets(): List<Set>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sets: List<Set>)
}