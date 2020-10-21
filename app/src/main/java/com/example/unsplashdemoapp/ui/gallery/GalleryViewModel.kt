package com.example.unsplashdemoapp.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.unsplashdemoapp.data.UsplashRepository

class GalleryViewModel @ViewModelInject constructor(private val repository: UsplashRepository) :
    ViewModel() {
}