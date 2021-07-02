package com.raywenderlich.coursesshemajamebeli.network

import com.raywenderlich.coursesshemajamebeli.model.ApiData
import retrofit2.Response
import retrofit2.http.POST

interface Network {

    @POST("29db8caa-95cb-44be-aa3c-eee0aa406870")
    suspend fun getData(): Response<ApiData>

}