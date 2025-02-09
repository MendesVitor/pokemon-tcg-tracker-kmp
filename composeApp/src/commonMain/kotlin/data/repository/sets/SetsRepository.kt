package data.repository.sets

import domain.model.Set

interface SetsRepository {
    suspend fun getSets(): List<Set>
}
