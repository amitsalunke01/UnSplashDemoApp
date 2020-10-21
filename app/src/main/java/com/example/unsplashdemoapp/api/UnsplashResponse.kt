package com.example.unsplashdemoapp.api

import com.example.unsplashdemoapp.data.UnsplashPhoto

data class UnsplashResponse(
    val result: List<UnsplashPhoto>
)

/*
"results": [
    {
      "id": 193913,
      "title": "Office",
      "description": null,
 */