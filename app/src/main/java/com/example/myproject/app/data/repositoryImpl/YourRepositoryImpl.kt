package com.example.myproject.app.data.repositoryImpl

import com.example.myproject.app.data.remote.dto.YourDto
import com.example.myproject.app.domain.datasource.IYourDataSource
import com.example.myproject.app.domain.repository.IYourRepository
import com.example.myproject.app.domain.subscribers.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class YourRepositoryImpl @Inject constructor(
    private val source: IYourDataSource
): IYourRepository{

    override suspend fun getData(): Flow<Resource<YourDto>> {
        TODO("Not yet implemented")
    }
}