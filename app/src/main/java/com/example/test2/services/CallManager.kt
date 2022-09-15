package com.example.test2.services

import com.example.test2.interfaces.ApiServiceInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallManager {

    companion object {
        const val SERVER_BASE_URL = "http://testandroid.macropay.com.mx"
        const val TIME_OUT:Long = 100

        private var apiService: ApiServiceInterface? = null;


        fun getApiServiceManager() : ApiServiceInterface? {
            if (apiService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl(SERVER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService  = retrofit.create(ApiServiceInterface::class.java)
            }
            return apiService
        }
    }



}