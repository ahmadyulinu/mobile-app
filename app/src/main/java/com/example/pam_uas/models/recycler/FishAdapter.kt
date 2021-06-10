package com.example.pam_uas.models.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.FishItems
import com.squareup.picasso.Picasso

class FishAdapter(private val data: ArrayList<FishItems>): RecyclerView.Adapter<FishAdapter.FishViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder {
       // val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_fishes, parent, false)
        return FishViewHolder(view)
    // return FishHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class FishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: FishItems) {
            var imageView: ImageView = itemView.findViewById(R.id.recycler_gambar_ikan)
            var text1: TextView? = null
            var text2: TextView? = null

            imageView = itemView.findViewById(R.id.recycler_gambar_ikan)
            text1 = itemView.findViewById(R.id.tvFishName)
            text2 = itemView.findViewById(R.id.tvStatus)




            Picasso.get().load(data.foto).into(imageView)
            // imageView?.setImageResource(data.imgView)
            text1?.text = data.nama_ikan
            text2?.text = data.harga




            itemView.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: FishItems)
    }

}