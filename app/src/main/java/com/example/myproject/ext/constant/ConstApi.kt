package com.example.myproject.ext.constant

import com.example.myproject.MyProject

object ConstApi {

    init {
        System.loadLibrary("myproject")
    }

    private external fun getEndPoint(): String
    private external fun getEandPoint(): String

    val ENDPOINT = getEndPoint()

}