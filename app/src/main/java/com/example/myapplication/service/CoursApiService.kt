package com.example.myapplication.service


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "aws-0-eu-central-1.pooler.supabase.com"
private const val BASE_KEY = "93moovedatabase."
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface CoursApiService {
    @GET("cours")
    suspend fun getCoursList(): CoursListResponse
}
object CoursApi {
    val retrofitService : CoursApiService by lazy {
        retrofit.create(CoursApiService::class.java)
    }
}