package presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.usecase.GetSetsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import domain.model.Set
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SetsViewModel: ViewModel(), KoinComponent {
    private val getSetsUseCase: GetSetsUseCase by inject()

    private val _sets = MutableStateFlow<List<Set>>(emptyList())
    val sets: StateFlow<List<Set>> = _sets


    init {
        fetchSets()
    }

    private fun fetchSets() = viewModelScope.launch {
        try {
        _sets.value = getSetsUseCase.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
