package com.example.pam_uas.models.dataclass

data class FishItems (
    val id: Int,
    val nama_ikan: String,
    val slug: String,
    val deskripsi: String,
    val harga: String,
    val kuantitas: String,
    val foto: String,

    val deleted_at: String,
    val created_at: String,
    val updated_at: String
    )