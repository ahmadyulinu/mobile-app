package com.example.pam_uas.models.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.models.dataclass.items

class RecyclerAdapter(private val data: ArrayList<items>): RecyclerView.Adapter<RecyclerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
       val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return RecyclerHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}