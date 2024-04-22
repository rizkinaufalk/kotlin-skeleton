package com.example.myproject.app.di

import com.example.myproject.app.data.datasourceimpl.YourDataSourceImpl
import com.example.myproject.app.data.remote.MyApi
import com.example.myproject.app.domain.datasource.IYourDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun providesYourDataSource (
        myApi: MyApi
    ): IYourDataSource = YourDataSourceImpl(myApi)
}