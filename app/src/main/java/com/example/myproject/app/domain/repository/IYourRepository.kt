package com.example.myproject.app.domain.repository

import com.example.myproject.app.data.remote.dto.YourDto
import id.co.kalacakra.bcas.app.domain.subscribers.Resource
import kotlinx.coroutines.flow.Flow

interface IYourRepository {

    suspend fun getData(): Flow<Resource<YourDto>>

}