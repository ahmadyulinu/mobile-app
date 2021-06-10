package com.example.pam_uas.models.dataclass

data class post(
    val id_user: String,
    val nama: String,
    val alamat: String,
    val jumlah_pesanan: Int,
    val harga_total: Int,
    val status_transaksi: String = "DIPROSES",
    val transaction_details: Array<Int>

)
