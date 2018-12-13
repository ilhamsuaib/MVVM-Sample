package id.ilhamsuaib.mvvm.utils.extensions

import com.google.gson.Gson

/**
 * Created by @ilhamsuaib on 14/12/18.
 * github.com/ilhamsuaib
 */

fun Any.toJson() = Gson().toJsonTree(this)