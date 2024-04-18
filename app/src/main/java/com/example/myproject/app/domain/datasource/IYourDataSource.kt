package com.example.myproject.app.domain.datasource

import com.example.myproject.app.data.remote.dto.YourDto

interface IYourDataSource {

    suspend fun getData(page: String): YourDto
}