package id.ilhamsuaib.mvvm.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

open class BaseViewModel : ViewModel() {

    protected val disposables = CompositeDisposable()
}