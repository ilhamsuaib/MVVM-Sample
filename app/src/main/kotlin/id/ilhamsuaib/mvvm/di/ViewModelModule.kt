package id.ilhamsuaib.mvvm.di

import id.ilhamsuaib.mvvm.presentation.features.home.HomeViewModel
import id.ilhamsuaib.mvvm.utils.Constants
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

val viewModelModule: Module = module {

    viewModel { HomeViewModel(get(named(Constants.DI_HOME_REPOSITORY))) }
}