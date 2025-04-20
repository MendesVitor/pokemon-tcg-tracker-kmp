package domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "rarities")
data class Rarity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)
