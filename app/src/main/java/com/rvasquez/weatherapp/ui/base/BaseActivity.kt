package com.rvasquez.weatherapp.ui.base

import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.rvasquez.weatherapp.common.extensions.gone
import com.rvasquez.weatherapp.common.extensions.snackbar
import com.rvasquez.weatherapp.common.extensions.visible

abstract class BaseActivity : AppCompatActivity() {
    fun showError(@StringRes errorMessage: Int, rootView: View) = snackbar(errorMessage, rootView)

    fun showError(errorMessage: String?, rootView: View) = snackbar(errorMessage ?: "", rootView)

    fun showLoading(progressBar: ProgressBar) = progressBar.visible()

    fun hideLoading(progressBar: ProgressBar) = progressBar.gone()
}