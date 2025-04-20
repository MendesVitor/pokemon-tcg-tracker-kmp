package domain.model

data class Album(
    val id: String,
    val title: String,
    val cards: List<Card>
)