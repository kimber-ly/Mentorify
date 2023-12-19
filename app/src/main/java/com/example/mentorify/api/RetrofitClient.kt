package com.example.mentorify.api

import com.example.mentorify.Models.GetProfileModel
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("register")
    fun registerUser(@Body info: UserBody): retrofit2.Call<ResponseBody>

    @POST("login")
    fun login(@Body info: UserLogin): retrofit2.Call<ResponseBody>

    @GET("profile")
    fun getProfile(): Call<GetProfileModel>
}

class RetrofitInstance {
    companion object {
        private const val BASE_URL: String = "https://23442ztw-3301.asse.devtunnels.ms/"

        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}