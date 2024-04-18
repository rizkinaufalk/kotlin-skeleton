package com.example.myproject.ext.datatype


fun Long?.orZero(): Long = this ?: 0L
fun Long?.orOne(): Long = this ?: 1L
