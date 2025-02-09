package org.example.poketcg.presentation.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SetDetailScreen(setId: String) {
    // Aqui você pode carregar mais informações com base no `setId` (exemplo: consultar o ViewModel)
    Text("Detalhes do Set: $setId")
}
