package id.ilhamsuaib.mvvm.di

import id.ilhamsuaib.mvvm.data.repository.HomeRepository
import id.ilhamsuaib.mvvm.data.repository.HomeRepositoryImpl
import id.ilhamsuaib.mvvm.utils.Constants
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by @ilhamsuaib on 07/12/18.
 * github.com/ilhamsuaib
 */

val repositoryModule: Module = module {

    single<HomeRepository>(named(Constants.DI_HOME_REPOSITORY)) {
        HomeRepositoryImpl(get(named(Constants.DI_API_SERVICE)))
    }
}