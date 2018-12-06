package id.ilhamsuaib.mvvm

import android.app.Application
import id.ilhamsuaib.mvvm.di.dataModule
import id.ilhamsuaib.mvvm.di.repositoryModule
import id.ilhamsuaib.mvvm.di.viewModelModule
import org.koin.android.ext.android.startKoin

/**
 * Created by @ilhamsuaib on 02/12/18.
 * github.com/ilhamsuaib
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(dataModule, repositoryModule, viewModelModule))
    }
}