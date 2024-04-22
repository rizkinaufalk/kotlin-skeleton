package com.example.myproject.app.domain.usecase.yourusecase.yourdata

import com.example.myproject.app.domain.repository.IYourRepository
import com.example.myproject.app.domain.subscribers.Resource
import javax.inject.Inject
import com.example.myproject.app.data.remote.dto.YourDto
import kotlinx.coroutines.flow.Flow

class GetDataUseCase @Inject constructor(
    private val repository: IYourRepository
) {
    suspend operator fun invoke(): Flow<Resource<YourDto>> {
        return repository.getData()
    }
}