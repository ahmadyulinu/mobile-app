package com.example.pam_uas.models.retrofit

import com.example.pam_uas.models.dataclass.*
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

    @POST("checkout")
    fun checkout(@Body checkoutRequest: CheckoutRequest): Call<(CheckoutResponse)>

    @GET("transactions/{id}")
    fun getOrder(
        @Path("id")
        id_user: Int?
    ): Call<ArrayList<items>>

}