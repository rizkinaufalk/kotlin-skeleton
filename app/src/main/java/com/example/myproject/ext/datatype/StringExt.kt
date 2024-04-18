package com.example.myproject.ext.datatype


    fun String?.isLetters(): Boolean = orEmpty().replace(" ", "").matches("^[a-zA-Z]*$".toRegex()).orFalse()
    fun String?.isNumeric(): Boolean = orEmpty().matches("[0-9]+".toRegex()).orFalse()
