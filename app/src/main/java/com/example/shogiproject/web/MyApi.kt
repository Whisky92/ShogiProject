package com.example.shogiproject.web

import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("posts/1/comments")
    suspend fun getPostItems(): Response<List<MyPostItem>>
}