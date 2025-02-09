package org.example.poketcg.domain.model

data class Card(
    val id: String,
    val name: String,
    val set: String,
    val rarity: String,
    val imageUrl: String
)
