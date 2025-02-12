package domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sets")
data class Set(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val releaseDate: String,
    val category: String
    //val cards: List<Card>
)