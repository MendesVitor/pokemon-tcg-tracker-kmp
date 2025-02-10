package presentation.ui.page

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
import presentation.viewModel.SetsViewModel

@OptIn(KoinExperimentalAPI::class)
@Composable
fun SearchScreen() {
    val viewModel = koinViewModel<SetsViewModel>()
    val sets by viewModel.sets.collectAsState()

    Column {
        Text("Search")
    }
}
