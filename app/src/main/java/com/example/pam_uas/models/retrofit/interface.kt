package com.example.pam_uas.models.retrofit

import com.example.pam_uas.models.dataclass.FishItems
import com.example.pam_uas.models.dataclass.post
import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("fish")
    fun getPosts(): Call<ArrayList<FishItems>>

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("checkout")
    fun createPost(
        @Field("id_user") id_user: String,
        @Field("nama") nama:String,
        @Field("alamat") alamat:String,
        @Field("jumlah_pesanan") jumlah_pesanan: Int,
        @Field("harga_total") harga_total: Int,
        @Field("status_transaksi") status_transaksi: String = "DIPROSES",
        @Field("transaction_details") transaction_details: Array<Int>
    ): Call<post>

}