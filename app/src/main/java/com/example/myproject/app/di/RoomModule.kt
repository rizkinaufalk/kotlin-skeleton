package com.example.myproject.app.di

import android.content.Context
import com.example.myproject.app.data.local.interfaces.IYourDao
import com.example.myproject.app.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideSourceDao(appDatabase: AppDatabase): IYourDao = appDatabase.yourDao()
}