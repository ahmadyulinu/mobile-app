package com.example.pam_uas.models.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CheckoutRequest {
    @SerializedName("id_user")
    @Expose
    var id_user: String?=null

    @SerializedName("nama")
    @Expose
    var nama: String?=null

    @SerializedName("alamat")
    @Expose
    var alamat: String?=null

    @SerializedName("jumlah_pesanan")
    @Expose
    var jumlah_pesanan: Int?=null


    @SerializedName("harga_total")
    @Expose
    var harga_total: Int?=null

    @SerializedName("status_transaksi")
    @Expose
    var status_transaksi: String?=null

    @SerializedName("transaction_details")
    @Expose
    var transaction_details: Array<Int>?=null
}