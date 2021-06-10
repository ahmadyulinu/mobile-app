package com.example.pam_uas.models.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.HorizontalItems

class HorizontalHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_horizontal, parent, false))  {

        private var imageView: ImageView? = null

    init {
        imageView = itemView.findViewById(R.id.horizontal_image)

    }

    fun bind(data: HorizontalItems) {
        imageView?.setImageResource(data.imgView)

    }

}