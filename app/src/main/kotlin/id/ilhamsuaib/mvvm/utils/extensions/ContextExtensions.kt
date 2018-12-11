package id.ilhamsuaib.mvvm.utils.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by @ilhamsuaib on 12/12/18.
 * github.com/ilhamsuaib
 */

fun Context.toast(message: String?) = message?.let {
    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
}