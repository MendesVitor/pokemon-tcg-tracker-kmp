package di

import domain.usecase.GetSetsUseCase
import data.repository.sets.SetsRepository
import data.repository.sets.SetsRepositoryImpl
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import viewmodel.SetsViewModel

expect fun platformModule(): Module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            provideRepositoryModule, provideUseCaseModule,
            provideViewModelModule, platformModule()
        )
    }

val provideRepositoryModule = module {
    singleOf(::SetsRepositoryImpl).bind(SetsRepository::class)
}

val provideUseCaseModule = module {
    singleOf(::GetSetsUseCase)
}

val provideViewModelModule = module {
    viewModelOf(::SetsViewModel)
}