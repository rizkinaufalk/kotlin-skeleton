package com.example.myproject.app.di

import com.example.myproject.app.data.repositoryImpl.YourRepositoryImpl
import com.example.myproject.app.domain.datasource.IYourDataSource
import com.example.myproject.app.domain.repository.IYourRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun providesMyApi(
        source: IYourDataSource
    ): IYourRepository = YourRepositoryImpl(source)

}