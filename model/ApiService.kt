package com.yucox.pillpulse.model

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("pillpulse/api/v1")
    suspend fun getPaginatedPillList(
        @Header("mail") mail: String,
        @Query("requestedMonth") requestedMonth: Int,
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Response<List<Pill>>

    @GET("pillpulse/api/v1/all")
    suspend fun getAllPills(
        @Header("mail") mail: String
    ): Response<List<Pill>>

    @POST("pillpulse/api/v1/save")
    suspend fun savePill(
        @Header("mail") mail: String,
        @Body pill: Pill
    ): Response<Void>

    @DELETE("pillpulse/api/v1")
    suspend fun deletePill(
        @Header("mail") mail: String,
        @Query("id") id: String
    ): Response<Void>
}