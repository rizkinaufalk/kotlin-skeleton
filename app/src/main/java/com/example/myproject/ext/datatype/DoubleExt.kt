package com.example.myproject.ext.datatype


fun Double?.orZero(): Double = this ?: 0.0
fun Double?.orOne(): Double = this ?: 1.0