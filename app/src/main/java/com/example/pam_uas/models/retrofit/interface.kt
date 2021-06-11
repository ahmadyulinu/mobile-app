package com.example.pam_uas.models.retrofit

import com.example.pam_uas.models.dataclass.FishItems
import com.example.pam_uas.models.dataclass.UserRequest
import com.example.pam_uas.models.dataclass.UserResponse
import com.example.pam_uas.models.dataclass.post
import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("fish")
    fun getPosts(): Call<ArrayList<FishItems>>

    @POST("login")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>

    @POST("register")
    fun register(
        @Body userRequest: UserRequest
    ): Call<(UserResponse)>

}