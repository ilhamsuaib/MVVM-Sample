package id.ilhamsuaib.mvvm.presentation.features.home

import id.ilhamsuaib.mvvm.base.BaseViewModel
import id.ilhamsuaib.mvvm.data.repository.HomeRepository

/**
 * Created by @ilhamsuaib on 03/12/18.
 * github.com/ilhamsuaib
 */

class HomeViewModel(private val repo: HomeRepository) : BaseViewModel() {

    fun getArticles() = repo.getArticles()
}