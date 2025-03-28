package com.example.myapplication.service


import com.example.myapplication.CoursListResponse
import com.example.myapplication.CoursResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "http://10.0.2.2:8080/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface CoursApiService {
    @GET("cours")
    suspend fun getCoursList(): List<CoursResult>
}
object CoursApi {
    val retrofitService : CoursApiService by lazy {
        retrofit.create(CoursApiService::class.java)
    }
}