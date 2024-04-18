package com.example.myproject.ext.delegate

import androidx.navigation.NavController
import com.example.myproject.R
import timber.log.Timber
import kotlin.system.exitProcess

interface ExceptionHandler {
    fun showException(navController: NavController)
}

class ExceptionHandlerImpl: ExceptionHandler {

    override fun showException(navController: NavController) {
        Thread.setDefaultUncaughtExceptionHandler(ExceptionHandlerLayout(navController))
    }
}

class ExceptionHandlerLayout(
    private val navController: NavController
) : Thread.UncaughtExceptionHandler {
    override fun uncaughtException(t: Thread, e: Throwable) {
//        navController.navigate(R.id.exception_handler_activity) change with your design
        Timber.e("ExceptionHandler: " + e.message + " >> " + e)
        e.printStackTrace()

        android.os.Process.killProcess(android.os.Process.myPid())
        exitProcess(1)
    }
}