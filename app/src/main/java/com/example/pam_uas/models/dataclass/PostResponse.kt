package com.example.pam_uas.models.dataclass

import com.google.gson.annotations.SerializedName

data class PostResponse(
    val id:Int,
    val nama_ikan:String?,
    @SerializedName("deskripsi")
    val desc:String?
)
