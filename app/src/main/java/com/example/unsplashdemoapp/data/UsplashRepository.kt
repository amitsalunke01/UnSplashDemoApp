package com.example.unsplashdemoapp.data

import com.example.unsplashdemoapp.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsplashRepository @Inject constructor(private val unsplashApi: UnsplashApi) {
}