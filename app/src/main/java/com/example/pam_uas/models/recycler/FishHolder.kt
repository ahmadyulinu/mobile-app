package com.example.pam_uas.models.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.FishItems
import com.squareup.picasso.Picasso
import com.example.pam_uas.models.recycler.FishAdapter

class FishHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_fishes, parent, false))  {

        var imageView: ImageView = itemView.findViewById(R.id.recycler_gambar_ikan)
        private var text1: TextView? = null
        private var text2: TextView? = null
        private var url = ""
        private var onItemClickCallback: FishAdapter.OnItemClickCallback? = null


    init {
        imageView = itemView.findViewById(R.id.recycler_gambar_ikan)
        text1 = itemView.findViewById(R.id.tvFishName)
        text2 = itemView.findViewById(R.id.tvStatus)
    }

    fun bind(data: FishItems) {
        // get image from links
        itemView.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
        url = data.foto
        Picasso.get().load(url).into(imageView)

        // imageView?.setImageResource(data.imgView)
        text1?.text = data.nama_ikan
        text2?.text = data.harga
    }

}