package data.repository.sets

import data.db.AppDatabase
import domain.model.Set


class SetsRepositoryImpl(private val appDatabase: AppDatabase) : SetsRepository {
    override suspend fun getSets(): List<Set> = appDatabase.setDao().getAllSets()
}