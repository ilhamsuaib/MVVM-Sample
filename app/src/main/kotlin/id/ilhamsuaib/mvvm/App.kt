package id.ilhamsuaib.mvvm

import android.app.Application
import androidx.work.Constraints
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import id.ilhamsuaib.mvvm.di.dataModule
import id.ilhamsuaib.mvvm.di.repositoryModule
import id.ilhamsuaib.mvvm.di.viewModelModule
import id.ilhamsuaib.mvvm.works.RefreshArticleWork
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.util.concurrent.TimeUnit

/**
 * Created by @ilhamsuaib on 02/12/18.
 * github.com/ilhamsuaib
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger(Level.ERROR)
            modules(dataModule, repositoryModule, viewModelModule)
        }

        setupWorkManagerJob()
    }
    /**
     * Setup WorkManager background job to 'fetch' new network data daily.
     */
    private fun setupWorkManagerJob() {
        /* Use constraints to require the work only run when the device is charging and the
        network is connected */
        val constraints = Constraints.Builder()
            .build()

        /*Specify that the work should attempt to run every day*/
        val work = PeriodicWorkRequest
            .Builder(RefreshArticleWork::class.java, 10, TimeUnit.SECONDS)
            .addTag(RefreshArticleWork.TAG)
            .setConstraints(constraints)
            .build()

        /*Enqueue it work WorkManager, keeping any previously scheduled jobs for the same
        work.*/
        WorkManager.getInstance()
            .enqueue(work)
        /*.enqueueUniquePeriodicWork(RefreshArticleWork::class.java.name, ExistingPeriodicWorkPolicy.KEEP, work)*/
    }
}