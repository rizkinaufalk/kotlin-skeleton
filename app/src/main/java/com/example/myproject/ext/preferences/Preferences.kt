package com.example.myproject.ext.preferences

object Preferences {
    init {
        System.loadLibrary("preferences")
    }

    private external fun getUsername(): String
    private external fun setUsername(username: String)
}