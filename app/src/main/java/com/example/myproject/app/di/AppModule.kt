package com.example.myproject.app.di

import android.content.Context
import com.example.myproject.MyProject
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context)
            : MyProject = app as MyProject

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: MyProject)
            : Context = context
}