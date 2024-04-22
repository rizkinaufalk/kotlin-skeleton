package com.example.myproject.ext.constant

import com.example.myproject.MyProject

object ConstApi {

    init {
        System.loadLibrary("myproject_app")
    }

    private external fun getEndPoint(): String

    val ENDPOINT = getEndPoint()

}