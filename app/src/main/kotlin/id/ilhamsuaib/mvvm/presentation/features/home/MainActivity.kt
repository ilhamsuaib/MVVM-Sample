package id.ilhamsuaib.mvvm.presentation.features.home

import android.os.Bundle
import id.ilhamsuaib.mvvm.R
import id.ilhamsuaib.mvvm.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
