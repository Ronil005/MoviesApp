package com.ronil.moviesapp.data.di

import com.ronil.moviesapp.data.remote.MoviesApi
import com.ronil.moviesapp.data.repository.MoviesRepositoryImpl
import com.ronil.moviesapp.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideMoviesApi(retrofit: Retrofit): MoviesApi = retrofit.create(MoviesApi::class.java)

    @Provides
    @Singleton
    fun provideMoviesRepository(api: MoviesApi): MoviesRepository = MoviesRepositoryImpl(api)

}