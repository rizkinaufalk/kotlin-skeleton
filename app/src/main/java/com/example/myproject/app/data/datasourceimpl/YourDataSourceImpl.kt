package com.example.myproject.app.data.datasourceimpl

import com.example.myproject.app.data.remote.MyApi
import com.example.myproject.app.data.remote.dto.YourDto
import com.example.myproject.app.domain.datasource.IYourDataSource
import javax.inject.Inject

class YourDataSourceImpl @Inject constructor(
    private val api: MyApi
): IYourDataSource {

    override suspend fun getData(page: String): YourDto = api.getData()

}