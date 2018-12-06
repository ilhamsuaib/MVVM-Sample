package id.ilhamsuaib.mvvm.di

import id.ilhamsuaib.mvvm.presentation.features.home.HomeViewModel
import id.ilhamsuaib.mvvm.utils.Constants
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

val viewModelModule = module {

    viewModel { HomeViewModel(get(Constants.DI_HOME_REPOSITORY)) }
}