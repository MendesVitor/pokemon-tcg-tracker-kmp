package domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "artists")
data class Artists (
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String
)

