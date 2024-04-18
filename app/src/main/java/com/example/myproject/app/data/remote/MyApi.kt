package com.example.myproject.app.data.remote

import com.example.myproject.app.data.remote.dto.YourDto

interface MyApi {

    suspend fun getData() : YourDto
}