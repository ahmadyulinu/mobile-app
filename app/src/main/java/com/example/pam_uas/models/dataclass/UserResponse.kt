package com.example.pam_uas.models.dataclass

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("email")
    @Expose
    var email: String?=null

    @SerializedName("password")
    @Expose
    var password: String?=null

    @SerializedName("name")
    @Expose
    var name: String?=null

    @SerializedName("token")
    @Expose
    var token: String?=null
}