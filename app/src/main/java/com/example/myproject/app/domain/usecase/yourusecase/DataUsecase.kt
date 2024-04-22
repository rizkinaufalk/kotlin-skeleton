package com.example.myproject.app.domain.usecase.yourusecase

import com.example.myproject.app.domain.usecase.yourusecase.yourdata.GetDataUseCase
import javax.inject.Inject

data class DataUsecase @Inject constructor(
    val getDataUseCase: GetDataUseCase
)
