package domain.usecase

import data.repository.sets.SetsRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetSetsUseCase : KoinComponent {
    private val setsRepository: SetsRepository by inject()
    suspend fun execute() = setsRepository.getSets()
}