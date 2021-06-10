package com.example.pam_uas.models.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.models.dataclass.HorizontalItems

class HorizontalAdapter(private val data: ArrayList<HorizontalItems>): RecyclerView.Adapter<HorizontalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalHolder {
       val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return HorizontalHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: HorizontalHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}