package com.data.retrofit

import com.data.response.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("events?active=0")
    fun getEvent(
        @Query("active") active: Int
    ): Call<EventResponse>
}