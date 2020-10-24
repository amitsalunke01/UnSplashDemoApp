package com.example.unsplashdemoapp.di

import android.app.Application
import com.example.unsplashdemoapp.api.UnsplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module //states that tells instructions to use provides (bag of all dependency)
@InstallIn(ApplicationComponent::class)//application singleton scope for whole application level
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    //.create(UnsplashApi::class.java)

    @Provides
    @Singleton
    fun providesUnsplashApi(retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)
}