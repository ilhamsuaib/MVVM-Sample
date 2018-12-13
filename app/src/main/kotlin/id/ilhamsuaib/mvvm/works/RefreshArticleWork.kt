package id.ilhamsuaib.mvvm.works

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.work.Result
import androidx.work.Worker
import androidx.work.WorkerParameters
import id.ilhamsuaib.mvvm.utils.logD

/**
 * Created by @ilhamsuaib on 12/12/18.
 * github.com/ilhamsuaib
 */

class RefreshArticleWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    companion object {
        const val TAG: String = "RefreshArticleWork"
    }

    /**
     * Do our actual processing for the worker.
     *
     * WorkManager will call this method from a background thread. It may be called even
     * after our app has been terminated by the operating system, in which case [WorkManager] will
     * start just enough to run this [Worker].
     */
    override fun doWork(): Result {
        return refreshTitle()
    }

    /**
     * Refresh the title from the network using [HomeRepository]
     */
    // TODO: Implement refreshArticle
    @WorkerThread
    private fun refreshTitle(): Result {
        logD(TAG, "refreshTitle : Work manager is working")
        return Result.success()
    }
}