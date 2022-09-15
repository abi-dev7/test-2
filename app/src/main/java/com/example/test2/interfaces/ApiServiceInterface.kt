package com.example.test2.interfaces

import com.example.test2.models.apiresponses.LoginResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiServiceInterface {

    @FormUrlEncoded
    @POST("")
    fun login2(
        @Field("email") email: String?,
        @Field("password") password: String?,
    ): Response<LoginResponse>?

    @POST(".")
    suspend fun login(@Body body: RequestBody): Response<LoginResponse>?
}