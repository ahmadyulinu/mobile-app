package com.example.pam_uas.models.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.items
import com.squareup.picasso.Picasso

class RecyclerHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_status, parent, false))  {

        private var imageView: ImageView? = null
        private var text1: TextView? = null
        private var text2: TextView? = null

    init {
        imageView = itemView.findViewById(R.id.recycler_gambar_ikan)
        text1 = itemView.findViewById(R.id.tvFishName)
        text2 = itemView.findViewById(R.id.tvStatus)
    }

    fun bind(data: items) {

//        imageView?.setImageResource(data.imgView)
        Picasso.get().load(data.foto).into(imageView)
        text1?.text = data.nama_ikan
        text2?.text = data.status_transaksi
    }

}