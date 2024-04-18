package com.example.myproject.ext.datatype


fun Int?.orZero(): Int = this ?: 0
fun Int?.orOne(): Int = this ?: 1
