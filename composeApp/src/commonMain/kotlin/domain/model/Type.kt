package domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "types")
data class Type (
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String
)
