package org.example.poketcg.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import navigation.NavigationManager
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import presentation.ui.viewmodel.SetsViewModel

@OptIn(KoinExperimentalAPI::class)
@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<SetsViewModel>()
    val sets by viewModel.sets.collectAsState()

    Column {
        Text("Sets")
        LazyColumn {
            items(sets) { set ->
                Card {
                    Button(onClick = {
                        NavigationManager.navigateToSetDetail(set.id.toString())
                    }) {
                        Text(set.name)
                    }
                }
            }
        }
    }
}
