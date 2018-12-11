package id.ilhamsuaib.mvvm.di

import id.ilhamsuaib.mvvm.data.repository.HomeRepository
import id.ilhamsuaib.mvvm.data.repository.HomeRepositoryImpl
import id.ilhamsuaib.mvvm.utils.Constants
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

/**
 * Created by @ilhamsuaib on 07/12/18.
 * github.com/ilhamsuaib
 */

val repositoryModule: Module = module {

    single<HomeRepository>(name = Constants.DI_HOME_REPOSITORY) {
        HomeRepositoryImpl(get(Constants.DI_API_SERVICE))
    }
}