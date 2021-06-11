package com.example.pam_uas.models.recycler

import android.icu.text.NumberFormat
import android.icu.util.Currency
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.pam_uas.R
import com.example.pam_uas.models.dataclass.FishItems
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

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
        @RequiresApi(Build.VERSION_CODES.N)
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


            var format: NumberFormat = NumberFormat.getCurrencyInstance()
            format.setCurrency(Currency.getInstance("IDR"))
            var string = data.harga.toBigDecimal()
            var formatted = format.format(string)


            text2?.text = formatted




            itemView.setOnClickListener{onItemClickCallback?.onItemClicked(data)}
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: FishItems)
    }

}