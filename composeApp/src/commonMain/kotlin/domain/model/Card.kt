package domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class Card(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val number: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "pokemon_type_id")
    val typeId: String,
    @ColumnInfo(name = "artist_id")
    val artistId: String,
    @ColumnInfo(name = "set_id")
    val setId: String,
    @ColumnInfo(name = "rarity_id")
    val rarityId: String
)
