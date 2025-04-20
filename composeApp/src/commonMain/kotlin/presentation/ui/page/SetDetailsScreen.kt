package presentation.ui.page

import androidx.compose.runtime.Composable
import domain.model.Card
import presentation.ui.components.CardGrid

@Composable
fun SetDetailScreen(setId: String) {
    val test = listOf<Card>(
        Card(
            id = 1,
            name = "Pikachu",
            number = "1",
            imageUrl = "https://dz3we2x72f7ol.cloudfront.net/expansions/surging-sparks/pt-br/SV08_PTBR_238-2x.png",
            typeId = "1",
            artistId = "1",
            setId = "1",
            rarityId = "1"
        ), Card(
            id = 1,
            name = "Pikachu",
            number = "1",
            imageUrl = "https://dz3we2x72f7ol.cloudfront.net/expansions/surging-sparks/pt-br/SV08_PTBR_238-2x.png",
            typeId = "1",
            artistId = "1",
            setId = "1",
            rarityId = "1"
        ), Card(
            id = 1,
            name = "Pikachu",
            number = "1",
            imageUrl = "https://dz3we2x72f7ol.cloudfront.net/expansions/surging-sparks/pt-br/SV08_PTBR_238-2x.png",
            typeId = "1",
            artistId = "1",
            setId = "1",
            rarityId = "1"
        ), Card(
            id = 1,
            name = "Pikachu",
            number = "1",
            imageUrl = "https://dz3we2x72f7ol.cloudfront.net/expansions/surging-sparks/pt-br/SV08_PTBR_238-2x.png",
            typeId = "1",
            artistId = "1",
            setId = "1",
            rarityId = "1"
        ), Card(
            id = 1,
            name = "Pikachu",
            number = "1",
            imageUrl = "https://dz3we2x72f7ol.cloudfront.net/expansions/surging-sparks/pt-br/SV08_PTBR_238-2x.png",
            typeId = "1",
            artistId = "1",
            setId = "1",
            rarityId = "1"
        ), Card(
            id = 1,
            name = "Pikachu",
            number = "1",
            imageUrl = "https://dz3we2x72f7ol.cloudfront.net/expansions/surging-sparks/pt-br/SV08_PTBR_238-2x.png",
            typeId = "1",
            artistId = "1",
            setId = "1",
            rarityId = "1"
        )
    )

    CardGrid(test)

}
